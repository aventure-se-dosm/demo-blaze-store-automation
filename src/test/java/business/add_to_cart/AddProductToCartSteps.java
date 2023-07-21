package business.add_to_cart;

import org.junit.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;

	@Quando("adiciono este produto ao carrinho")
	public void adicionoEsteProdutoAoCarrinho() {
		Assert.assertTrue(addToCartLogic.addProductToCart());
	}
	

	@Quando("clico na categoria desejada")
	public void clicoNaCategoriaDesejadaEmProductCategoryPage() {
		addToCartLogic = new AddToCartProductLogic();
		addToCartLogic.selectCategory();
		throw new PendingException();

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
