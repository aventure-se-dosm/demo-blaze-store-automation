package business.add_to_cart;

import java.util.List;

import org.junit.Assert;

import business.add_to_cart.AddProductToCartModel.ListGroupProductCategory;
import business.login.LoginLogic;
import core.utils.enums.ScenarioContextKeys;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test.context.TestContext;

public class AddProductToCartSteps {

	private static final ScenarioContextKeys PRODUCT_PRICES = null;
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
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory();
	}

	@Quando("clico na primeira categoria desejada em ProductCategoryPage")
	public void clicoNaPrimeiraCategoriaDesejadaEmProductCategoryPage() {
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


	@Quando("clico sobre o primeiro produto")
	public void clicoSobreOPrimeiroProduto() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.clickOnTheFirstProduct();
		addToCartLogic.saveCtxProductInfos();
	}
	
	@Quando("obtenho o preço total dos ítems do carrinho")
	public void obtenhoOPreçoTotalDosÍtemsDoCarrinho() {
		
		addToCartLogic.saveCartTotalValue();
	}
	
	@Então("a soma dos preços do primeiro e do segundo produtos")
	public void aSomaDosPreçosDoPrimeiroEDoSegundoProdutos() {
		
		int total = ((List<Integer>)TestContext.getScenarioContext().getValue(PRODUCT_PRICES))
				.stream()
				.reduce((p,q) -> (p+q))
				.get();
		
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
	@Então("O produto foi adicionado com sucesso")
	public void oProdutoFoiAdicionadoComSucesso() {
		Assert.assertTrue(addToCartLogic.isTheProductAddedToTheCart());
	}
}
