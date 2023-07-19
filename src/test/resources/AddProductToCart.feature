#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    Dado que estou logado na página
    Quando clico na categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

  @ID_0009 @DoisProdutos
  Cenário: Adicionar múltiplos produtos ao carrinho de compras
    Dado que estou logado na página
    Quando adiciono os dois produtos ao carrinho
    Então Ambos os produtos foram adicionados com sucesso
