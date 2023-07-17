#language: pt
Funcionalidade: Enviar mensagem de texto na seção contato

  @ID_0006
  Cenario: Escrever uma mensagem com sucesso
    Dado que estou na página inicial para enviar uma mensagem
    Quando clico no link Contact

    E preencho o campo Contact Name em ContactForm
    E preencho o campo Contact Email em ContactForm
    E preencho o campo Contact Name em ContactForm
    E escrevo uma mensagem no campo
    E clico no botão Send Message
    Então a mensagem foi enviada com sucesso
