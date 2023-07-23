#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

Contexto:
    Dado que estou logado na página
    
  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    Quando clico na categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então O produto foi adicionado com sucesso

