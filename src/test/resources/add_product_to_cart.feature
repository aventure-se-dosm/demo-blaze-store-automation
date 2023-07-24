#language: pt
Funcionalidade: Adicionar produtos ao carrinho de compras

  Fundo: 
    Dado que estou logado na aplicação para testar o cart 
    Quando clico em Cart em NavBarPage
    E o carrinho vazio
    E retorno para HomePage

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
    E clico na segunda categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então a soma dos preços do primeiro e do segundo produtos

  @ID_0010
  Cenario: Validar carrinho de compras vazio
  	Quando clico em Cart em NavBarPage
  	E o carrinho vazio
  	E retorno para HomePage
    E clico na primeira categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    E clico em Delete em CheckPage
    Então o carrinho está vazio

  @ID_0011
  Cenario: Remover um item do carrinho de compras
    Quando clico na primeira categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E retorno para HomePage
    Quando clico na segunda categoria desejada
    E clico sobre o primeiro produto
    E adiciono este produto ao carrinho
    E clico em Cart em NavBarPage
    Então a soma dos preços do primeiro e do segundo produtos
