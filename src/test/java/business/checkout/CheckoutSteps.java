package business.checkout;

import org.junit.Assert;

import business.add_to_cart.AddProductToCartLogic;
import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps {

	private CheckoutLogic checkoutLogic;
	private AddProductToCartLogic addToCartLogic;

	@Dado("que estou logado na aplicação para fechar um pedido")
	public void queEstouLogadoNaAplicaçãoParaFecharUmPedido() {
		addToCartLogic = new AddProductToCartLogic();
		checkoutLogic = new CheckoutLogic();
		LoginLogic loginLogic = new LoginLogic();
		loginLogic.startNavigation();
		loginLogic.startLogin();
		loginLogic.preencherUsuarioLogin();
		loginLogic.preencherSenhaLogin();
		loginLogic.sendLoginForm();
		Assert.assertTrue(loginLogic.isUserProperlyLoggedIn());
	}
	
	
	@Quando("clico no botão order em business.checkout page")
	public void clicoNoBotãoOrderEmCheckoutPage() {
	//	checkoutLogic = new CheckoutLogic();
		checkoutLogic.placeOrder();

		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho os campos de CheckoutForm")
	public void preenchoOsCamposDeCheckoutForm() {
		// Write code here that turns the phrase above into concrete actions
		getCheckoutLogic().fillForm();
		throw new io.cucumber.java.PendingException();
	}

	private CheckoutLogic getCheckoutLogic() {
		// TODO Auto-generated method stub
		if (this.checkoutLogic == null) {
			this.checkoutLogic = new CheckoutLogic();
		}
		return this.checkoutLogic;
	}


	@Quando("clico em submit em CheckoutForm")
	public void clicoEmSubmitEmCheckoutForm() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Então("a compra foi realizada com sucesso")
	public void aCompraFoiRealizadaComSucesso() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}