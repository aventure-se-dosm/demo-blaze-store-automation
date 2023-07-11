package business.logout_page;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test.context.TestContext;

public class LogoutSteps {

	private LogoutLogic logic;

	@Dado("que estou logado na página")
	public void queEstouLogadoNaPágina() {
		logic = new LogoutLogic();
		logic.startNavigation();
		logic.startLogin();
		logic.preencherUsuarioLogin();
		logic.preencherSenhaLogin();
		logic.sendLoginForm();
		Assert.assertTrue(logic.isUserProperlyLoggedIn());
	}

	@Quando("clico no link logout")
	public void clicoNoLinkLogout() {
		logic.logout();
	}

	@Então("realizo e logout")
	public void realizoELogout() {
		Assert.assertTrue(logic.isUserProperlyLoggedOut());
	}

}
