package business.checkout;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps {

	private CheckoutLogic checkoutLogic;

	@Quando("clico no botão order em business.checkout page")
	public void clicoNoBotãoOrderEmCheckoutPage() {
		checkoutLogic = new CheckoutLogic();
		checkoutLogic.placeOrder();

		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho os campos de CheckoutForm")
	public void preenchoOsCamposDeCheckoutForm() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
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