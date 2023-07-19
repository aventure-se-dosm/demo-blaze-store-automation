#language: pt
Funcionalidade: Filtrar por categoria no catálogo de produtos

  @ID_0007
  Cenario: Filtrar produtos pela categoria e haver exibido ao menos um produto de determinada marca
    Dado que estou logado na página para filtrar o produto
    Quando clico na categoria desejada em ProductCategoryPage
    Então Há pelo menos um produto com a marca desejada
