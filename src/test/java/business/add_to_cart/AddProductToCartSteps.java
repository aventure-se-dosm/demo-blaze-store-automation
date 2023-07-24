package business.add_to_cart;

import org.junit.Assert;

import business.login.LoginLogic;
import business.logout.LogoutLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test_enums.Attributes.FilterProductAtttributes;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;
	private LoginLogic loginLogic;

	
	@Dado("que estou logado na aplicação para testar o cart")
	public void queEstouLogadoNaAplicaçãoParaTestarOCart() {
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
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory();
	}

	@Quando("clico na primeira categoria desejada")
	public void clicoNaPrimeiraCategoriaoDesejada() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory(FilterProductAtttributes.CATEGORIA_1);
	}

	@Quando("clico na segunda categoria desejada")
	public void clicoNaSegundaCategoriaDesejada() {
		
		addToCartLogic.selectCategory(FilterProductAtttributes.CATEGORIA_2);
	}

	@Quando("retorno para HomePage")
	public void retornoParaHomePage() {
		addToCartLogic.goToHomePage();

	}

	@Quando("clico em Cart em NavBarPage")
	public void clicoEmCartEmNavBarPage() {
		addToCartLogic.goToNavBar();
	}

	@Quando("clico em Delete em CheckPage")
	public void clicoEmDeleteEmCheckPage() {
		addToCartLogic.deleteAddedProduct();
	}

	@Então("o produto foi removido com sucesso")
	public void oProdutoFoiRemovidoComSucesso() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(addToCartLogic.isAddedProductRemoved());
	}

	@Então("O produto foi adicionado com sucesso")
	public void oProdutoFoiAdicionadoComSucesso() {
		Assert.assertTrue(addToCartLogic.isTheProductAddedToTheCart());

	}

	@Quando("clico sobre o primeiro produto")
	public void clicoSobreOPrimeiroProduto() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.clickOnTheFirstProduct();
		addToCartLogic.saveCtxProductInfos();
	}

	@Então("a soma dos preços do primeiro e do segundo produtos")
	public void aSomaDosPreçosDoPrimeiroEDoSegundoProdutos() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

}
