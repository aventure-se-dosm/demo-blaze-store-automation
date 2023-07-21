#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    Dado que estou logado na página
    Quando clico na categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

