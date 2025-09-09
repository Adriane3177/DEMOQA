# language: pt

Funcionalidade: Testar Inclusão, Atualização e Exclusão do usuário com sucesso
  Cenário: Validar o crud no formulario
    Dado que acesso o site demoqa com sucesso
    E ao clicar no menu Elements
    E ao clicar no submenu Web Tables
    E ao clicar no botão Add
    E ao preencher o formulário com a inclusao do usuario
    Quando clicar no botao Submit do cadastro do usuario
    Entao as informações do usuario novo deveria ser exibida na grid
    E ao selecionar o usuario novo cadastrado('Fulano')
    E ao clicar no icone Editar do usuario
    E ao preencher o formulário com as alteracoes do usuario
    Quando clicar no botao Submit do cadastro do usuario
    Entao as informações das alteracoes do usuario novo deveriam serem exibidas na grid
    E ao selecionar o usuario novo cadastrado('Fulano1')
    Quando ao clicar no icone Deletar do usuario
    Entao o registro do usuario novo não deveria ser exibida na grid
    E ao preencher o formulário com a inclusao de 12 usuarios
    Entao as informações de todos os 12 usuarios novos deveriam serem exibidas na grid
    E selecionar opcao de ver 100 registros na tela
    E apagar todos os 12 usuarios cadastrados
    Entao as informações de todos os 12 usuarios novos nao deveriam serem exibidas na grid
    E o navegador deveria ser fechado

