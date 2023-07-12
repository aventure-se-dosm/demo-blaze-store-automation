#language: pt

Funcionalidade: Realizar o cadastro de um usuário na aplicação

Fundo: Tentar Cadastrar um usuário já cadastrado na aplicação com dados aleatórios
  Dado que estou na página Home Page para realizar meu cadastro
    Quando clico no link Sign Up em HomePage
    E preencho o campo Username em SignUpForm
    E preencho o campo Password em SignUpForm
    E clico no botão Submit em SignUpForm

  @ID_0003
  Cenario:  Cadastrar usuário na aplicação
    Então o usuário foi cadastrado com sucesso

  @ID_0004
  Cenario: Validar alerta ao tentar cadastrar um usuário já existente na aplicação
    Então um alerta com a mensagem This user already exist. é exibido