#language: pt
Funcionalidade: Preencher o formulário de compra para finalizá-la com sucesso

  Fundo: 
    Dado que estou logado na aplicação para fechar um pedido
     Quando clico em Cart em NavBarPage
    E o carrinho vazio
    E retorno para HomePage
    Quando clico na primeira categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    E clico na segunda categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage

  @ID_0012
  Cenario: Preencher o formulário para finalizar a compra com sucesso
    Quando a soma dos preços do primeiro e do segundo produtos é igual ao total
    E clico no botão order em business.checkout page
    E preencho os campos de CheckoutForm
    E clico em submit em CheckoutForm
    Então a compra foi realizada com sucesso
