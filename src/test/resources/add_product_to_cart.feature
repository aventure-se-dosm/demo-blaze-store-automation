#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras



Fundo: checo o valor total dos produtos já inseridos no carrinho
    Dado que estou logado na aplicação
    Quando clico em Cart em NavBarPage
    E obtenho o preço total dos ítems do carrinho
    E retorno para HomePage

  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    #Dado que estou logado na aplicação
    #Quando clico em Cart em NavBarPage
    #E obtenho o preço total dos ítems do carrinho
    Quando clico na categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

  @ID_0009
  Cenario: Adicionar múltiplos produto ao carrinho de compras
    #Dado que estou logado na aplicação
    #Quando clico na primeira categoria desejada em ProductCategoryPage
    #E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    Quando clico na segunda categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então a soma dos preços do primeiro e do segundo produtos 
    Então O produto foi adicionado com sucesso
