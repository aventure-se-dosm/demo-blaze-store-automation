package business.add_to_cart;

import org.junit.Assert;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;

	@Quando("adiciono os dois produtos ao carrinho")
	public void adicionoOsDoisProdutosAoCarrinho() {
		throw new io.cucumber.java.PendingException();
	}

	@Então("Ambos os produtos foram adicionados com sucesso")
	public void ambosOsProdutosForamAdicionadosComSucesso() {
		throw new io.cucumber.java.PendingException();
	}

	@Quando("adiciono este produto ao carrinho")
	public void adicionoEsteProdutoAoCarrinho() {
		Assert.assertTrue(addToCartLogic.addProductToCart());
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
