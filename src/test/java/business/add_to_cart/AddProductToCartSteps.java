package business.add_to_cart;

import org.junit.Assert;

import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test_enums.Attributes.FilterProductAtttributes;

public class AddProductToCartSteps {

	private AddProductToCartLogic addToCartLogic;
	private LoginLogic loginLogic;
	
	private AddProductToCartLogic getAddToCartLogic() {
		if (addToCartLogic == null) {
			this.addToCartLogic = new AddProductToCartLogic();
		}
		return this.addToCartLogic;
	}

	@Dado("que estou logado na aplicação para testar o cart")
	public void queEstouLogadoNaAplicaçãoParaTestarOCart() {
		addToCartLogic = new AddProductToCartLogic();
		loginLogic = new LoginLogic();
		loginLogic.startNavigation();
		loginLogic.startLogin();
		loginLogic.preencherUsuarioLogin();
		loginLogic.preencherSenhaLogin();
		loginLogic.sendLoginForm();
		Assert.assertTrue(loginLogic.isUserProperlyLoggedIn());
	}

	@Quando("adiciono este produto ao carrinho")
	public void adicionoEsteProdutoAoCarrinho() {
		Assert.assertTrue(addToCartLogic.addProductToCart());
	}

	@Quando("clico na categoria desejada")
	public void clicoNaCategoriaDesejada() {
		getAddToCartLogic().selectCategory();
	}

	@Quando("clico na primeira categoria desejada")
	public void clicoNaPrimeiraCategoriaoDesejada() {
		
		getAddToCartLogic().selectCategory(FilterProductAtttributes.CATEGORIA_1);
	}

	@Quando("clico na segunda categoria desejada")
	public void clicoNaSegundaCategoriaDesejada() {
		getAddToCartLogic().selectCategory(FilterProductAtttributes.CATEGORIA_2);
	}

	@Quando("retorno para HomePage")
	public void retornoParaHomePage() {
		getAddToCartLogic().goToHomePage();
	}

	@Quando("clico em Cart em NavBarPage")
	public void clicoEmCartEmNavBarPage() {
		getAddToCartLogic().goToNavBar();
	}

	@Quando("clico em Delete em CheckPage")
	public void clicoEmDeleteEmCheckPage() {
		getAddToCartLogic().deleteAddedProduct();
	}
	
	@Quando("removo o primeiro produto")
	public void removoOPrimeiroProduto() {
		getAddToCartLogic().deleteAddedProduct();	
	}
	@Então("o preço final é o preço do ultimo produto")
	public void oPreçoFinalÉOPreçoDoUltimoProduto() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Então("o carrinho está vazio")
	public void oCarrinhoEstáVazio() {
		Assert.assertTrue(addToCartLogic.isCartEmpty());
	}
	
	@E("o carrinho vazio")
	public void oCarrinhoVazio() {
		getAddToCartLogic().deleteAddedProducts();
	}

	@Quando("clico sobre o primeiro produto")
	public void clicoSobreOPrimeiroProduto() {
		getAddToCartLogic().clickOnTheFirstProduct();
		getAddToCartLogic().saveCtxProductInfos();
	}

	@Então("o produto foi removido com sucesso")
	public void oProdutoFoiRemovidoComSucesso() {
		Assert.assertTrue(addToCartLogic.isAddedProductRemoved());
	}

	@Então("O produto foi adicionado com sucesso")
	public void oProdutoFoiAdicionadoComSucesso() {
		Assert.assertTrue(addToCartLogic.isTheProductAddedToTheCart());
	}

	@Então("a soma dos preços do primeiro e do segundo produtos é igual ao total")
	public void aSomaDosPreçosDoPrimeiroEDoSegundoProdutosÉIgualAoTotal() {
		Assert.assertTrue(addToCartLogic.isCartTotalEqualsToTheSumOfEverySingleProduct());
	}

}
