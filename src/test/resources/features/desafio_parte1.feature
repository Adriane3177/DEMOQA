# language: pt
Funcionalidade: Validar a aPis
  Cenario: Criar usuário, gerar token de acesso, verificar autorização, listar livros alugar 2 livros e ver detalhes do usuário
    Dado que eu crio um usuário com userID, userName e password válidos
    E gero um token de acesso para o usuário informado
    E verifico se o usuário está autorizado
    Quando consulto a lista de livros disponíveis
    E seleciono dois livros para alugar para o usuário
    Entao os dados do usuário devem conter os dois livros alugados
   