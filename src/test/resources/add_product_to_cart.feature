#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

Contexto:
     Dado que estou logado na aplicação para testar o cart
    
  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras

    Quando clico na categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

  @ID_0009
  Cenario: Adicionar múltiplos produto ao carrinho de compras

    Quando clico na primeira categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    Quando clico na segunda categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então a soma dos preços do primeiro e do segundo produtos
    #Então O produto foi adicionado com sucesso
    
    @ID_0010
  Cenario: Adicionar e remover um produto do carrinho

    Quando clico na primeira categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    E clico em Delete em CheckPage
    Então o produto foi removido com sucesso

