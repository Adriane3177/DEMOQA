# language: pt

Funcionalidade: Preencher formulário com sucesso
  Cenário: Validar o cadastro do usuario no formulario com sucesso
    Dado que acesso o site demoqa com sucesso
    E ao clicar no menu Form
    E ao clicar no submenu Practice Form
    E ao preencher o formulário
    E ao informar o arquivo para upload
    Quando clicar no botao submitButton
    Entao ao clicar em fechar a nova tela com as informações do usuario deveria exibir a tela anterior
    E o navegador deveria ser fechado
