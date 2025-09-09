# language: pt

Funcionalidade: Exibir nova pagina no navegador
  Cenário: Validar o funcionamento dos Alerts, Frame & Windows
    Dado que acesso o site demoqa com sucesso
    E ao clicar no menu Alerts, Frame e Windows
    E ao clicar no submenu Browse Windows
    Quando ao clicar no botão New Window
    Então deveria exibir uma nova página no navegador
    E o navegador deveria ser fechado