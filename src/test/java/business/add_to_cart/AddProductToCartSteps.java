package business.add_to_cart;

import org.junit.Assert;

import business.filter_products.FilterProductLogic;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;

	@Quando("adiciono este produto ao carrinho")
	public void adicionoEsteProdutoAoCarrinho() {
		Assert.assertTrue(addToCartLogic.addProductToCart());
	}
	
	@Quando("clico na categoria desejada em ProductCategoryPage")
	public void clicoNaCategoriaDesejadaEmProductCategoryPage() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory();
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
