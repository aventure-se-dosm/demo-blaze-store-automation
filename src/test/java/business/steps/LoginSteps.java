package business.steps;

import org.junit.Assert;

import business.login_page.LoginLogic;
import business.login_page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test.context.TestContext;
//MELHORA ESSA BAGAÇA ;-)
//CLASSE PATH DO JAVA... Tá de enfeite é?

public class LoginSteps {

	private LoginPage loginPage;
	private LoginLogic logic;

	// o model deve estar pronto antes do acesso.
	// via algum método setup chamado pela hook
	// da classe contexto
	// hora de implementar

	@Dado("que estou na página Home Page")
	public void queEstouNaPáginaInicial() throws InterruptedException {
//ou inicializa ou apela pro picocontainer... why not?
		logic = new LoginLogic();
		logic.startNavigation();
		Assert.assertEquals(logic.getUrlDaPaginaAtual(), TestContext.getConfigReader().getHomePage());
		// throw new io.cucumber.java.PendingException();
	}

	// problema: incluimos na loginPage a HomePage...
	@Quando("clico no link Login em HomePage")

	public void clicoNoLinkLoginEmHomePage() {
		logic.startLogin();
		// Assert.assertEquals(loginLinkText, clickedLinkText);
		// throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho o campo Username em LoginForm")
	public void preenchoOCampoUsernameEmLoginForm() {
		//
		logic.preencherUsuarioLogin();

//		throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho o campo Password em LoginForm")
	public void preenchoOCampoPasswordEmLoginForm() {
		//
		logic.preencherSenhaLogin();

		// throw new io.cucumber.java.PendingException();
	}

	@Quando("clico no botão Submit")
	public void clicoEnoBotãoSubmit() {
		// Write code here that turns the phrase above into concrete actions
		logic.sendLoginForm();

		// throw new io.cucumber.java.PendingException();
	}

	@Então("o usuário foi logado com sucesso")
	public void oUsuárioFoiLogadoComSucesso() {
		Assert.assertTrue(logic.isUserProperlyLogged());
	}
}
