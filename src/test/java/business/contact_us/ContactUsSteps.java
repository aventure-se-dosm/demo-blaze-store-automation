package business.contact_us;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class ContactUsSteps {
	private ContactUsLogic logic;

	@Dado("que estou na página inicial para enviar uma mensagem")
	public void queEstouNaPáginaInicialParaEnviarUmaMensagem() {
		logic = new ContactUsLogic();
		
	}

	@Quando("clico no link Contact")
	public void clicoNoLinkContact() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho o campo Contact Name em ContactForm")
	public void preenchoOCampoContactNameEmContactForm() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("preencho o campo Contact Email em ContactForm")
	public void preenchoOCampoContactEmailEmContactForm() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Quando("escrevo uma mensagem no campo")
	public void escrevoUmaMensagemNoCampo() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
