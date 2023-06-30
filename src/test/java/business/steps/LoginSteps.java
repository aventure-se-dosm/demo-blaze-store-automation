package business.steps;

import business.login_page.LoginLogic;
import business.login_page.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	private LoginPage page;
	private LoginLogic logic;

	@Dado("que estou na página Home Page")
	public void queEstouNaPáginaInicial() throws InterruptedException {
//		page = new LoginPage();
//		page.startBrowser();
//		page.login();

		// passar para um ScenarioCOntext info. para validação:
		// acho excelente
		// mas as classes Step FAZ a lógica pra validar OU só aplica?
		// pensando em validar ou na tal 'logic' (ex AbstractStep).

//		Assert.assertTrue(TestContext.getScenarioContext.get());
		/*
		 * //assert fraco: e snão contiver o protocolo ou sem a barra final... só o URI?
		 * Assert.assertTrue(
		 * page.getCurrentUrl().equalsIgnoreCase(TestContext.getConfigReader().
		 * getHomePage()) );
		 */


		throw new io.cucumber.java.PendingException();
	}

	@Quando("clico no link {string} em {string}")
	public void clicoNoLinkEm(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho o campo {string} em {string}")
	public void preenchoOCampoEm(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("clico eno botão {string}")
	public void clicoEnoBotão(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Então("o usuário foi logado com sucesso")
	public void oUsuárioFoiLogadoComSucesso() {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}
}
