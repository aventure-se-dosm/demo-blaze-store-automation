package business.cadastro;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import test.context.TestContext;

public class CadastroSteps {

	private CadastroLogic logic;

	@Dado("que estou na página Home Page para realizar meu cadastro")
	public void queEstouNaPáginaInicialParaRelizarMeuCadastro() throws InterruptedException {
		logic = new CadastroLogic();
		logic.startNavigation();
		Assert.assertEquals(logic.getUrlDaPaginaAtual(), TestContext.getConfigReader().getHomePage());
	}

	@Quando("clico no link Sign Up em HomePage")
	public void clicoNoLinkSignupEmHomePage() {
		logic.startCadastro();
	}

	@Quando("preencho o campo Username em SignUpForm")
	public void preenchoOCampoUsernameEmLoginForm() {
		logic.preencherUsuarioCadastro();
	}

	@Quando("preencho o campo Password em SignUpForm")
	public void preenchoOCampoPasswordEmLoginForm() {
		logic.preencherSenhaCadastro();
	}

	@Quando("clico no botão Submit em SignUpForm")
	public void clicoEnoBotãoSubmit() {
		logic.sendCadastroForm();
	}

	@Quando("preencho o campo Username em SignUpForm com valor aleatório")
	public void preenchoOCampoUsernameEmSignUpFormComValorAleatório() {
		logic.preencherUsuarioCadastro("ci39dndq".concat(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
	}
	@Quando("preencho o campo Password em SignUpForm com valor aleatório")
	public void preenchoOCampoPasswordEmSignUpFormComValorAleatório() {
		logic.preencherSenhaCadastro("asdasd".concat(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)));
	}

	@Então("o usuário foi cadastrado com sucesso")
	public void oUsuárioFoiLogadoComSucesso() {
		Assert.assertTrue(logic.isUserSignedUp());
	}

	@Então("um alerta com a mensagem This user already exist. é exibido")
	public void UmAlertaComAMensagemÉExibido() {
		Assert.assertTrue(logic.isUserAlreadyExistent());
	}

}
