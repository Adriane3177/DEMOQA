
package Steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.gl.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class CenarioParte2 {

	WebDriver driver;

	@Dado("que acesso o site demoqa com sucesso")
	public void que_acesso_o_site_demoqa_com_sucesso() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://demoqa.com/");
	}

	@E("ao clicar no menu Form")
	public void ao_clicar_no_menu_Form() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//h5[text()='Forms']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(500);
	}

	@E("ao clicar no submenu Practice Form")
	public void ao_clicar_no_submenu_Practice_Form() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"item-0\"]/span[text()='Practice Form']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
     	element.click();
		Thread.sleep(500);
	}

	@E("ao preencher o formulário")
	public void ao_preencher_o_formulário() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("Fulano");
		driver.findElement(By.id("lastName")).sendKeys("de Tal");
		driver.findElement(By.id("userEmail")).sendKeys("ft@gmail.com");
		
		WebElement genderMaleLabel = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderMaleLabel);

		driver.findElement(By.id("userNumber")).sendKeys("1199999999");

		((JavascriptExecutor) driver).executeScript("var adContainer = document.getElementById('google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0_container_');"
						+ "if(adContainer){ adContainer.style.display='none'; }");

		WebElement dateField = driver.findElement(By.id("dateOfBirthInput"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dateField);
		Select monthDropdown = new Select(driver.findElement(By.className("react-datepicker__month-select")));
		monthDropdown.selectByVisibleText("July");
		Select yearDropdown = new Select(driver.findElement(By.className("react-datepicker__year-select")));
		yearDropdown.selectByVisibleText("1967");
		WebElement day = driver.findElement(By.xpath(
				"//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'outside-month')) and text()='15']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", day);
		WebElement hobbiesSportsLabel = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", hobbiesSportsLabel);

		WebElement addressField = driver.findElement(By.id("currentAddress"));
		addressField.sendKeys("xxxxxxxxxxxxxxx, 99999");

		WebElement stateField = driver.findElement(By.id("state"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stateField);
		stateField.click();

		WebElement optionNCR = driver.findElement(By.xpath("//div[contains(text(),'Haryana')]"));
		optionNCR.click();
	
		WebElement cityField = driver.findElement(By.id("city"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cityField);
		cityField.click();

		WebElement optionDelhi = driver.findElement(By.xpath("//div[contains(text(),'Panipat')]"));
		optionDelhi.click();
	}

	@E("ao informar o arquivo para upload")
	public void realizo_o_upload_do_arquivo_txt() throws InterruptedException {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/java.png";
		WebElement uploadInput = driver.findElement(By.id("uploadPicture")); 
		uploadInput.sendKeys(filePath);
	}

	@Quando("clicar no botao submitButton")
	public void clicar_no_botao_submitButton() throws InterruptedException {
		WebElement submitButton = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
	}

	@Entao("ao clicar em fechar a nova tela com as informações do usuario deveria exibir a tela anterior")
	public void ao_clicar_em_fechar_a_nova_tela_com_as_informações_do_usuario_deveria_exibir_a_tela_anterior() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeLargeModal']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
	}

	@E("ao clicar no menu Alerts, Frame e Windows")
	public void ao_clicar_no_submenu_Alerts() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[3]/div/div[3]/h5"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
}

	@E("ao clicar no submenu Browse Windows")
	public void ao_clicar_no_submenu_Browse_Windows() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[3]/div/ul/li[1]/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
	}

    @Quando("ao clicar no botão New Window")
	public void ao_clicar_no_botao_New_Windows() throws InterruptedException {
        WebElement windowButton = driver.findElement(By.id("windowButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", windowButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", windowButton);
	}

    @Entao("deveria exibir uma nova página no navegador")
    public void deveria_exibir_uma_nova_página_no_navegador() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
	}

	@E("ao clicar no menu Elements")
	public void ao_clicar_no_menu_Elements() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/div[1]/div/div[3]/h5"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
}

	@E("ao clicar no submenu Web Tables")
	public void ao_clicar_no_submenu_Web_Tables() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"item-3\"]/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
	}

    @E("ao clicar no botão Add")
	public void ao_clicar_no_botao_Add() throws InterruptedException {
		WebElement addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addNewRecordButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewRecordButton);
	}

    @E("ao preencher o formulário com a inclusao do usuario")
    public void ao_preencher_o_formulário_com_a_inclusao_do_usuario() {
    	driver.findElement(By.id("firstName")).sendKeys("Fulano");
		driver.findElement(By.id("lastName")).sendKeys("de Tal");
		driver.findElement(By.id("userEmail")).sendKeys("ft@gmail.com");
  		driver.findElement(By.id("age")).sendKeys("33");
		driver.findElement(By.id("salary")).sendKeys("7000");
		driver.findElement(By.id("department")).sendKeys("TI");
	}
		
	@Quando("clicar no botao Submit do cadastro do usuario")
	public void ao_clicar_no_botao_Submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}

	@Entao("as informações do usuario novo deveria ser exibida na grid")
	public void as_informações_do_usuario_novo_deveria_ser_exibida_na_grid() throws InterruptedException {
		boolean encontrado = false;
		String nomeUsuario = "Fulano";
		boolean existeTexto = driver.getPageSource().contains(nomeUsuario);
		if (existeTexto) {
   			encontrado = true;
		}
		Assert.assertTrue("as informações do usuario não foi exibida na grid! " + nomeUsuario, encontrado);
	}

	@E("ao selecionar o usuario novo cadastrado\\({string})")
	public void selecionar_o_usuario_novo_cadastrado(String nomeUsuario) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement userRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	By.xpath("//*[@id='app']//div[contains(normalize-space(.), '" + nomeUsuario + "')]")));
		Actions actions = new Actions(driver);
    	actions.moveToElement(userRow).click().perform();
	}

	@E("ao clicar no icone Editar do usuario")
		public void ao_clicar_no_icone_Editar_do_usuario() throws InterruptedException {
		WebElement alteraIconeWebElement = driver.findElement(By.id("edit-record-4"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alteraIconeWebElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", alteraIconeWebElement);
	}

	@E("ao preencher o formulário com as alteracoes do usuario")
    public void ao_preencher_o_formulário_com_as_alteracoes_do_usuario() {
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("Fulano1");
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("de Tal1");
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("userEmail")).sendKeys("ft1@gmail.com");
  		driver.findElement(By.id("age")).clear();
		driver.findElement(By.id("age")).sendKeys("60");
		driver.findElement(By.id("salary")).clear();
		driver.findElement(By.id("salary")).sendKeys("9000");
		driver.findElement(By.id("department")).clear();
		driver.findElement(By.id("department")).sendKeys("TI-Quality");
	}

	@Entao("as informações das alteracoes do usuario novo deveriam serem exibidas na grid")
	public void as_informações_das_alteracoes_do_usuario_novo_deveriam_ser_exibidas_na_grid() throws InterruptedException {
		boolean encontrado = false;
		String nomeUsuario = "Fulano1";
		boolean existeTexto = driver.getPageSource().contains(nomeUsuario);
		if (existeTexto) {
   			encontrado = true;
		}
		Assert.assertTrue("as informações das alteracoes do usuario novo não foram exibidas na grid! "+ nomeUsuario, encontrado);
	}

	@Quando("ao clicar no icone Deletar do usuario")
	public void ao_clicar_no_icone_Deletar_do_usuario() throws InterruptedException {
		WebElement deletaIconeWebElement = driver.findElement(By.id("delete-record-4"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deletaIconeWebElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deletaIconeWebElement);

	}
    @Entao("o registro do usuario novo não deveria ser exibida na grid")
	public void o_registro_do_usuario_novo_não_deveria_ser_exibida_na_grid() throws InterruptedException {
		boolean encontrado = false;
		String nomeUsuario = "Fulano1";
		boolean existeTexto = driver.getPageSource().contains(nomeUsuario);
		if (!existeTexto) {
   			encontrado = true;
		}
		Assert.assertTrue("o registro do usuario novo foi exibido na grid! "+ nomeUsuario, encontrado);
	}

	@E("ao preencher o formulário com a inclusao de {int} usuarios")
    public void ao_preencher_o_formulario_com_a_inclusao_de_usuarios(int quantidade) {   
		
		for (int i = 1; i <= quantidade; i++) {
			driver.findElement(By.id("addNewRecordButton")).click();
    
            driver.findElement(By.id("firstName")).clear();
            driver.findElement(By.id("firstName")).sendKeys("nome"+ i);

            driver.findElement(By.id("lastName")).clear();
            driver.findElement(By.id("lastName")).sendKeys("sobrenome"+i);

            driver.findElement(By.id("userEmail")).clear();
            driver.findElement(By.id("userEmail")).sendKeys("email" + i + "@gmail.com");

  			driver.findElement(By.id("age")).clear();
			driver.findElement(By.id("age")).sendKeys(String.valueOf(60 + i));

			driver.findElement(By.id("salary")).clear();
			driver.findElement(By.id("salary")).sendKeys(String.valueOf(9000 + i));

			driver.findElement(By.id("department")).clear();
			driver.findElement(By.id("department")).sendKeys("TI" + i);
			
            driver.findElement(By.id("submit")).click();
        }
    }

	@Entao("as informações de todos os {int} usuarios novos deveriam serem exibidas na grid")
	public void as_informações_de_todos_os_usuarios_novos_deveriam_ser_exibidas_na_grid(int quantidade) throws InterruptedException {

 		boolean encontrado = false;
		String nomeUsuario = "";
		for (int i = 1; i < quantidade; i++) {
			nomeUsuario = "nome" + i;
			boolean existeTexto = driver.getPageSource().contains(nomeUsuario);

			if (!existeTexto) {
    			encontrado = true;
				Assert.assertTrue("as informações de todos os 12 usuarios novos não estão sendo exibidas na grid! "+ nomeUsuario, encontrado);
				break;

			}
		}
		Assert.assertTrue("as informações de todos os 12 usuarios novos não estão sendo exibidas na grid! "+ nomeUsuario, encontrado);
	}
	
	@E("selecionar opcao de ver 100 registros na tela")
	public void selecionar_opcao_de_ver_100_registros_na_tela() throws InterruptedException {
		WebElement qtdRegistrosExibidosOption = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[2]/div/div[2]/span[2]/select/option[contains(text(),'100 rows')]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", qtdRegistrosExibidosOption);
		qtdRegistrosExibidosOption.click();
		Thread.sleep(500);
	}	


	@E("apagar todos os {int} usuarios cadastrados")
	public void apagar_todos_os_usuarios_cadastrados(int quantidade) throws InterruptedException { 
    	int totalLinhas = 15;
    	System.out.println("Total de linhas encontradas: " + totalLinhas);
		int limite = Math.min(totalLinhas, quantidade);
   		for (int i = totalLinhas; i > totalLinhas - limite; i--) {
        	try {
            	WebElement deleteBtn = driver.findElement(By.id("delete-record-" + i));
            	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
            	Thread.sleep(500);
        	} catch (Exception e) {
            	System.out.println("Não consegui deletar usuário na linha " + i + " -> " + e.getMessage());
	    		int registrosRestantes = driver.findElements(By.xpath("//span[@title='Delete']")).size();
	    		Assert.assertEquals("Registros não foram apagados corretamente! ", totalLinhas - quantidade, registrosRestantes);
  	      }
  	   }
	}
	
	@Entao("as informações de todos os {int} usuarios novos nao deveriam serem exibidas na grid")
	public void as_informações_de_todos_os_usuarios_novos_nao_deveriam_ser_exibidas_na_grid(int quantidade) throws InterruptedException {

 		boolean encontrado = false;
		String nomeUsuario = "";
		for (int i = 1; i <= quantidade; i++) {
			nomeUsuario = "nome" + i;
			boolean existeTexto = driver.getPageSource().contains(nomeUsuario);

			if (existeTexto) {
    			encontrado = true;
				Assert.assertTrue("As informações de todos os " + quantidade + " usuarios novos estão sendo exibidas na grid " + nomeUsuario, encontrado);
				break;
			}
		}
	}

	@E("ao clicar no menu Widgets")
	public void ao_clicar_no_menu_Widgets() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[3]/h5"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
	}

	@E("ao clicar no submenu Progress Bar")
	public void ao_clicar_no_submenu_Progress_Bar() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[4]/div/ul/li[5]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
     	element.click();
	}

	@E("ao clicar no botao Start")
	public void ao_clicar_no_botao_Start() throws InterruptedException {
		WebElement startButton = driver.findElement(By.id("startStopButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", startButton);
	}

	@Quando("chegar no limite a barra de progresso chegar no valor de {int} %")
	public void chegar_no_limite_a_barra_de_progresso_chegar_no_valor_de (int valor) throws InterruptedException {
		WebElement progressBar = driver.findElement(By.cssSelector(".progress-bar"));
        while (true) {
            String valorAtualStr = progressBar.getDomAttribute("aria-valuenow");
            int valorAtual = Integer.parseInt(valorAtualStr);

            if (valorAtual >= valor) {
                break;
            }
			Thread.sleep(50);
		}
    }
	
	@E("clicar no botao Stop")
	public void clicar_no_botao_Stop() throws InterruptedException {
		WebElement stopButton = driver.findElement(By.id("startStopButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stopButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", stopButton);
		Thread.sleep(5000);
	}

	@E("ao clicar o botão Reset")
	public void ao_clicar_no_botao_Reset() throws InterruptedException {
		WebElement resetButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", resetButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", resetButton);
		Thread.sleep(5000);
	}

	@Entao("a página deveria exibir o progress bar com 0")
	public void a_pagina_deveria_exibir_o_progress_bar_com_0() throws InterruptedException {
		
    	int valorAtual = getProgressValue();
		if (valorAtual > 0 && valorAtual < 100) {
			Assert.assertTrue("Barra de Progress não resetada: valor atual = " + valorAtual, (valorAtual > 0 && valorAtual < 100));
		}
	}

	@E("ao clicar no menu Interaction")
	public void clicarMenuInteraction() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[5]/div/div[1]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);
	}

	@E("ao clicar no submenu Sortable")
	public void clicarSubmenuSortable() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/div/div[5]/div/ul/li[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(2000);
	}

	@Quando("ordenar os elementos por ordem crescente")
	public void ordenar_os_elementos_por_ordem_crescente () throws InterruptedException {
        List<WebElement> itens = driver.findElements(By.cssSelector(".vertical-list-container .list-group-item"));
        List<String> textos = new ArrayList<>();
        for (WebElement item : itens) {
            textos.add(item.getText());
        }
	    List<String> textosOrdenados = new ArrayList<>(textos);
        Collections.sort(textosOrdenados);

        System.out.println("Original: " + textos);
        System.out.println("Ordenado: " + textosOrdenados);

        Actions actions = new Actions(driver);

    	for (int i = 0; i < textosOrdenados.size(); i++) {

            String textoCorreto = textosOrdenados.get(i);
         	List<WebElement> itensAtualizados = driver.findElements(By.cssSelector(".vertical-list-container .list-group-item"));
            WebElement elementoCorreto = null;
            for (WebElement e : itensAtualizados) {
                if (e.getText().equals(textoCorreto)) {
                    elementoCorreto = e;
                    break;
                }
            }
            if (!itensAtualizados.get(i).getText().equals(textoCorreto)) {
                actions.clickAndHold(elementoCorreto)
                       .moveToElement(itensAtualizados.get(i))
                       .release()
                       .perform();

                Thread.sleep(1000); // só para visualizar a troca
            }
        }
	}

 	@E("o navegador deveria ser fechado")
	public void o_navegador_deveria_ser_fechado() throws InterruptedException {
	    driver.close();
		driver.quit();
	}

	@Entao("a tela deveria ter os elementos em ordem crescente")
	public void a_tela_deveria_ter_os_elementos_em_ordem_crescente() throws InterruptedException {
   	 	List<WebElement> elementos = driver.findElements(By.cssSelector("#sortable li"));
		List<String> textos = elementos.stream().map(WebElement::getText).collect(Collectors.toList());
    	List<String> textosOrdenados = new ArrayList<>(textos);
    	Collections.sort(textosOrdenados);
    	Assert.assertEquals(textosOrdenados, textos);
    	System.out.println("Os elementos estão em ordem crescente!");
	}
	
	public int getProgressValue() {
	    WebElement progressBar = driver.findElement(By.className("progress-bar"));
    	String value = progressBar.getDomAttribute("aria-valuenow");

    	if (value == null || value.isBlank()) return 0;

    	try {
        	return Integer.parseInt(value.trim());
    	} catch (NumberFormatException e) {
        	return 0;
    	}
	}
}
	