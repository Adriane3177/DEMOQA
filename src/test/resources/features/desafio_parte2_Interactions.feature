# language: pt

Funcionalidade: Verificar as ordens crecentes dos elementos
  Cenário: Validar o cadastro do usuario no formulario com sucesso
    Dado que acesso o site demoqa com sucesso
    E ao clicar no menu Interaction
    E ao clicar no submenu Sortable
    Quando ordenar os elementos por ordem crescente
    Entao a tela deveria ter os elementos em ordem crescente
    E o navegador deveria ser fechado