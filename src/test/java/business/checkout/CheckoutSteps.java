package business.checkout;

import org.junit.Assert;

import business.login.LoginLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps {

	private CheckoutLogic checkoutLogic;

	@Dado("que estou logado na aplicação para fechar um pedido")
	public void queEstouLogadoNaAplicaçãoParaFecharUmPedido() {
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

		checkoutLogic.placeOrder();

	}

	@Quando("preencho os campos de CheckoutForm")
	public void preenchoOsCamposDeCheckoutForm() {
		getCheckoutLogic().fillForm();
	}

	private CheckoutLogic getCheckoutLogic() {

		if (this.checkoutLogic == null) {
			this.checkoutLogic = new CheckoutLogic();
		}
		return this.checkoutLogic;
	}

	@Quando("clico em submit em CheckoutForm")
	public void clicoEmSubmitEmCheckoutForm() {
		getCheckoutLogic().sendForm();
	}

	@Então("a compra foi realizada com sucesso")
	public void aCompraFoiRealizadaComSucesso() {
		getCheckoutLogic().isOrderFinishedSuccessifully();
	}
}