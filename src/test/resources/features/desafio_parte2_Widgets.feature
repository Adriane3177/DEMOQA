# language: pt

Funcionalidade: Testar o funcionamento da barra de progresso
  Cenário: Validar a barra de progresso
    Dado que acesso o site demoqa com sucesso
    E ao clicar no menu Widgets
    E ao clicar no submenu Progress Bar
    E ao clicar no botao Start
    Quando chegar no limite a barra de progresso chegar no valor de 25 %
    Entao clicar no botao Stop
    E ao clicar no botao Start
    Quando chegar no limite a barra de progresso chegar no valor de 100 %
    E ao clicar o botão Reset
    Entao a página deveria exibir o progress bar com 0
    E o navegador deveria ser fechado

