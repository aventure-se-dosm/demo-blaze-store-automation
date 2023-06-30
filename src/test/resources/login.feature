#language: pt
Funcionalidade: Realizar login na aplicação

  @ID_0001
  Cenario: O usuário cadastrado realiza login com sucesso
    Dado que estou na página Home Page
    Quando clico no link 'login' em 'HomePage'
    E preencho o campo 'Username' em 'LoginForm'
    E preencho o campo 'Password' em 'LoginForm'
    E clico eno botão 'submit'
    Então o usuário foi logado com sucesso
