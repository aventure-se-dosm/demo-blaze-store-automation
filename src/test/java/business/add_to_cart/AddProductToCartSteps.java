package business.add_to_cart;

import org.junit.Assert;

import business.add_to_cart.AddProductToCartModel.ListGroupProductCategory;
import business.login.LoginLogic;
import io.cucumber.java.PendingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;
	private LoginLogic loginLogic;

	@Dado("que estou logado na aplicação")
	public void queEstouLogadoNaAplicação() {
		loginLogic = new LoginLogic();
		loginLogic.startNavigation();
		loginLogic.startLogin();
		loginLogic.preencherUsuarioLogin();
		loginLogic.preencherSenhaLogin();
		loginLogic.sendLoginForm();
		Assert.assertTrue(loginLogic.isUserProperlyLogged());
	}

	@Quando("adiciono este produto ao carrinho")
	public void adicionoEsteProdutoAoCarrinho() {
		Assert.assertTrue(addToCartLogic.addProductToCart());
	}

	@Quando("clico na categoria desejada em ProductCategoryPage")
	public void clicoNaCategoriaDesejadaEmProductCategoryPage() {
		clicoNaPrimeiraCategoriaDesejadaEmProductCategoryPage();
	}

	@Quando("clico na primeira categoria desejada em ProductCategoryPage")
	public void clicoNaPrimeiraCategoriaDesejadaEmProductCategoryPage() {
		// Write code here that turns the phrase above into concrete actions
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory(ListGroupProductCategory.LAPTOPS);
	}

	@Quando("clico na segunda categoria desejada em ProductCategoryPage")
	public void clicoNaSegundaCategoriaDesejadaEmProductCategoryPage() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory(ListGroupProductCategory.MONITORS);
	}

	@Quando("retorno para HomePage")
	public void retornoParaHomePage() {
		addToCartLogic.goToHomePage();
	}

	@Quando("clico em Cart em NavBarPage")
	public void clicoEmCartEmNavBarPage() {
		addToCartLogic.goToNavBar();
	}

	@Então("O produto foi adicionado com sucesso")
	public void oProdutoFoiAdicionadoComSucesso() {
		throw new PendingException();
		//Assert.assertTrue(addToCartLogic.isTheProductAddedToTheCart());

	}

	@Quando("clico sobre o primeiro produto")
	public void clicoSobreOPrimeiroProduto() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.clickOnTheFirstProduct();
		addToCartLogic.saveCtxProductInfos();
	}
}
