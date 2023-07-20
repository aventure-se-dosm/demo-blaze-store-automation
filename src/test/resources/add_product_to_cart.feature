#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    Dado que estou logado na aplicação
    Quando clico na categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

  @ID_0009
  Cenario: Adicionar múltiplos produto ao carrinho de compras
    Dado que estou logado na aplicação
    Quando clico na primeira categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    Quando clico na segunda categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso
