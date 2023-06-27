package business.steps;

import business.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	Page page = new LoginPage();
	
	@Dado("que estou na página inicial")
	public void queEstouNaPáginaInicial() throws InterruptedException {
		
		
		page.startBrowser();
		Thread.sleep(3000);
		page.closeBrowser();
		
		throw new io.cucumber.java.PendingException();
	}

	@Quando("clico no link {string} em {string}")
	public void clicoNoLinkEm(String string, String string2) {
	
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
		throw new io.cucumber.java.PendingException();
	}
}
