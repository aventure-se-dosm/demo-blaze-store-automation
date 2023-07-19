package business.add_to_cart;

import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AddProductToCartSteps {

	private AddToCartProductLogic addToCartLogic;
	private LoginLogic loginLogic;

	@Dado("que estou logado na página para adicioná-lo ao carrinho")
	public void queEstouLogadoNaPáginaParaAdicionarUmProdutoAoCarrinho() {
		loginLogic = new LoginLogic();
		addToCartLogic = new AddToCartProductLogic();
		loginLogic = new LoginLogic();
		loginLogic.startNavigation();
		loginLogic.startLogin();
		loginLogic.preencherUsuarioLogin();
		loginLogic.preencherSenhaLogin();
		loginLogic.sendLoginForm();
		// Assert.assertTrue(loginLogic.isUserProperlyLogged());
		// throw new PendingException();
	}

	@Quando("adiciono os dois produtos ao carrinho")
	public void adicionoOsDoisProdutosAoCarrinho() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Então("Ambos os produtos foram adicionados com sucesso")
	public void ambosOsProdutosForamAdicionadosComSucesso() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


@Quando("adiciono este produto ao carrinho")
public void adicionoEsteProdutoAoCarrinho() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
@Então("O produto foi adicionado com sucesso")
public void oProdutoFoiAdicionadoComSucesso() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

	@Quando("clico sobre o primeiro produto")
	public void clicoSobreOPrimeiroProduto() {
		addToCartLogic.clickOnTheFirstProduct();
	}
}
