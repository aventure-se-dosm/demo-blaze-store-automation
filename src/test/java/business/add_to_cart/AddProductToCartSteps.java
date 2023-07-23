package business.add_to_cart;

import org.junit.Assert;

import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test_enums.Attributes.FilterProductAtttributes;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;
	LoginLogic loginLogic;

	@Dado("que estou logado na aplicação")
	public void queEstouLogadoNaPágina() {
		loginLogic = new LoginLogic();
		addToCartLogic = new AddToCartProductLogic();
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

	@Quando("clico na categoria do produto desejada")
	public void clicoNaCategoriaDoProdutoDesejada() {
		// addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory();
	}

	@Quando("clico na primeira categoria desejada")
	public void clicoNaPrimeiraCategoriaoDesejada() {
		// addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory(FilterProductAtttributes.CATEGORIA_1);
	}

	@Quando("clico na segunda categoria desejada")
	public void clicoNaSegundaCategoriaDesejada() {
		// addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory(FilterProductAtttributes.CATEGORIA_2);
	}

	@Quando("retorno para HomePage")
	public void retornoParaHomePage() {
		addToCartLogic.goToHomePage();
		;
	}

	@Quando("clico em Cart em NavBarPage")
	public void clicoEmCartEmNavBarPage() {
		addToCartLogic.goToNavBar();
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
}