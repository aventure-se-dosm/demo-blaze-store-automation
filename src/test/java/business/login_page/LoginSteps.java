package business.login_page;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test.context.TestContext;

public class LoginSteps {

	private LoginLogic logic;

	@Dado("que estou na página Home Page")
	public void queEstouNaPáginaInicial() throws InterruptedException {
		logic = new LoginLogic();
		logic.startNavigation();
		Assert.assertEquals(logic.getUrlDaPaginaAtual(), TestContext.getConfigReader().getHomePage());
	}

	@Quando("clico no link Login em HomePage")

	public void clicoNoLinkLoginEmHomePage() {
		logic.startLogin();
	}

	@Quando("clico no botão Submit")
	public void clicoEnoBotãoSubmit() {
		logic.sendLoginForm();
	}

	@Quando("preencho o campo Username em LoginForm")
	public void preenchoOCampoUsernameEmLoginForm() {
		logic.preencherUsuarioLogin();
	}

	@Quando("preencho o campo Password em LoginForm")
	public void preenchoOCampoPasswordEmLoginForm() {
		logic.preencherSenhaLogin();
	}

	@Então("o usuário foi logado com sucesso")
	public void oUsuárioFoiLogadoComSucesso() {
		Assert.assertTrue(logic.isUserProperlyLogged());
	}
}
