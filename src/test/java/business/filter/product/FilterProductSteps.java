package business.filter.product;

import org.junit.Assert;

import business.userlog.logout.LogoutLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FilterProductSteps {

	private LogoutLogic loginlogic;
	private FilterProductLogic logic;

	@Dado("que estou logado na página")
	public void queEstouLogadoNaPágina() {
		loginlogic = new LogoutLogic();
		loginlogic.startNavigation();
		loginlogic.startLogin();
		loginlogic.preencherUsuarioLogin();
		loginlogic.preencherSenhaLogin();
		loginlogic.sendLoginForm();
		Assert.assertTrue(loginlogic.isUserProperlyLoggedIn());
		throw new io.cucumber.java.PendingException();
	}

	@Quando("clico na categoria desejada")
	public void clicoNaCategoriaDesejada() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("estou na página ProductListPage")
	public void estouNaPáginaProductListPage() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Então("ao menos um produto da marca é exibido")
	public void aoMenosUmProdutoDaMarcaÉExibido() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
}
