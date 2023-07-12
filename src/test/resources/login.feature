#language: pt
Funcionalidade: Realizar login na aplicação

  @ID_0001
  Cenario: O usuário cadastrado realiza login com sucesso
    Dado que estou na página Home Page para me logar
    Quando clico no link Login em HomePage
    E preencho o campo Username em LoginForm
    E preencho o campo Password em LoginForm
    E clico no botão Submit
    Então o usuário foi logado com sucesso
