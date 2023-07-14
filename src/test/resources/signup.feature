#language: pt
Funcionalidade: Realizar o cadastro de um usuário na aplicação

  Fundo: Tentar Cadastrar um usuário já cadastrado na aplicação com dados aleatórios
    Dado que estou na página Home Page para realizar meu cadastro
    Quando clico no link Sign Up em HomePage

  @ID_0003
  Cenario: Cadastrar usuário na aplicação com sucesso
    E preencho o campo Username em SignUpForm com valor aleatório
    E preencho o campo Password em SignUpForm com valor aleatório
    E clico no botão Submit em SignUpForm
    Então o usuário foi cadastrado com sucesso

  @ID_0004
  Cenario: Tentar cadastrar usuário já cadastrado na aplicação
    E preencho o campo Username em SignUpForm
    E preencho o campo Password em SignUpForm
    E clico no botão Submit em SignUpForm
    Então um alerta com a mensagem This user already exist. é exibido
