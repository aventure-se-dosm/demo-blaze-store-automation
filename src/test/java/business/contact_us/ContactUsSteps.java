package business.contact_us;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ContactUsSteps {
	private ContactUsLogic logic;

	@Dado("que estou na página inicial para enviar uma mensagem")
	public void queEstouNaPáginaInicialParaEnviarUmaMensagem() {
		logic = new ContactUsLogic();
		logic.startNavigation();
	}

	@Quando("clico no link Contact")
	public void clicoNoLinkContact() {
		logic.goToContactUs();
	}

	@E("preencho o campo Contact Name em ContactForm")
	public void preenchoOCampoContactNameEmContactForm() {
		logic.fillTxtContactName();
	}

	@E("preencho o campo Contact Email em ContactForm")
	public void preenchoOCampoContactEmailEmContactForm() {
		logic.fillTxtContactEmail();
	}

	@E("escrevo uma mensagem no campo")
	public void escrevoUmaMensagemNoCampo() {
		logic.fillMessage();
	}
	
	@Quando("clico no botão xxx")
	public void clicoNoBotãoXxx() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Então("a mensagem foi enviada com sucesso")
	public void aMensagemFoiEnviadaComSucesso() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
