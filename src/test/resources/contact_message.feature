#language: pt
Funcionalidade: Enviar mensagem de texto na seção contato

  @ID_0006
  Cenario: Escrever uma mensagem com sucesso
    Dado que estou na página inicial para enviar uma mensagem
    Quando clico no link Contact
    #parametrizar a mensagem aqui: não parece bem
    E preencho o campo Contact Name em ContactForm
    E preencho o campo Contact Email em ContactForm
    E escrevo uma mensagem no campo
    Então o elemento que representa o vídeo é exibido
