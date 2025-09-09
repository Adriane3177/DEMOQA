package Steps;

import static org.hamcrest.Matchers.is;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class CenárioParte1 {

	String userId;
	String token;

	@Dado("que eu crio um usuário com userID, userName e password válidos")
	public void que_eu_crio_um_usuário_com_userID_userName_e_password_válidos() {

		RestAssured.baseURI = "https://demoqa.com";

		String requestBody = """
				{
				    "userID": 0,
				    "userName": "Fulano de Tal-22",
				    "password": "Senha@2025"
				}
				""";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(requestBody).when().post("/Account/v1/User").then().statusCode(201).extract().response();

		userId = response.jsonPath().getString("userID");
		System.out.println("Usuário criado com ID: " + userId);
	}

	@E("gero um token de acesso para o usuário informado")
	public void gero_um_token_de_acesso_para_o_usuário_informado() {

		String requestBody = """
				{
				    "userName": "Fulano de Tal-22",
				    "password": "Senha@2025"
				}
				""";

		Response response = given().header("accept", "application/json").header("Content-Type", "application/json")
				.body(requestBody).when().post("/Account/v1/GenerateToken").then().statusCode(200).extract().response();

		token = response.jsonPath().getString("token");
		System.out.println("Token gerado: " + token);
	}

	@E("verifico se o usuário está autorizado")
	public void verifico_se_o_usuário_está_autorizado() {

		String requestBody = """
				{
				    "userName": "Fulano de Tal-22",
				    "password": "Senha@2025"
				}
				""";

		given().header("accept", "application/json").header("Content-Type", "application/json").body(requestBody).when()
				.post("/Account/v1/Authorized").then().statusCode(200);

		System.out.println("Usuário está autorizado.");
	}

	@Quando("consulto a lista de livros disponíveis")
	public void eu_consulto_a_lista_de_livros_disponíveis() {

		Response response = given().header("accept", "application/json").when().get("/BookStore/v1/Books").then()
				.statusCode(200).extract().response();

		System.out.println("Lista de livros: " + response.getBody().asPrettyString());
	}

	@E("seleciono dois livros para alugar para o usuário")
	public void seleciono_dois_livros_e_associo_ao_usuário() {
		Response livrosResponse = given().header("accept", "application/json").when().get("/BookStore/v1/Books").then()
				.statusCode(200).extract().response();

		String isbn1 = livrosResponse.jsonPath().getString("books[0].isbn");
		String isbn2 = livrosResponse.jsonPath().getString("books[1].isbn");

		String payload = String.format("""
				{
				  "userId": "%s",
				  "collectionOfIsbns": [
				    {"isbn": "%s"},
				    {"isbn": "%s"}
				  ]
				}
				""", userId, isbn1, isbn2);

		given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json").body(payload)
				.when().post("/BookStore/v1/Books").then().statusCode(201);

		System.out.println("Livros associados ao usuário com sucesso.");
	}

	@Entao("os dados do usuário devem conter os dois livros alugados")
	public void os_dados_do_usuário_devem_conter_os_dois_livros_alugados() {
		Response response = given().header("Authorization", "Bearer " + token).header("accept", "application/json")
				.when().get("/Account/v1/User/" + userId).then().statusCode(200).body("books.size()", is(2)).extract()
				.response();

		System.out.println("Detalhes do usuário:\n" + response.getBody().asPrettyString());
	}
}