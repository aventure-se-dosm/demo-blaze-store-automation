#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

  @ID_0008
  Cenario: Adicionar um produto ao carrinho de compras
    Dado que estou logado na página para adicioná-lo ao carrinho
    Quando clico na categoria desejada em ProductCategoryPage
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    Então O produto foi adicionado com sucesso

  @ID_0009 @DoisProditos
  Cenário: Adicionar múltiplos produtos ao carrinho de compras
    Dado que estou logado na página para adicioná-lo ao carrinho
    Quando adiciono os dois produtos ao carrinho
    Então Ambos os produtos foram adicionados com sucesso
