#language: pt
Funcionalidade: Filtrar por categoria no catálogo de produtos

  @ID_0007
  Cenario: Filtrar por uma uma categoria e um produto de certa marca é exibido
  
  Dado que estou logado na página
  Quando clico na categoria desejada
  E estou na página ProductListPage
  Então ao menos um produto da marca é exibido
  