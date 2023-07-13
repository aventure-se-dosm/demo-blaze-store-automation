package business.about_us;

import org.junit.Assert;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class AboutUsSteps {
	private AboutUsLogic logic;

	@Dado("que estou na página inicial para assistir ao vídeo")
	public void queEstouNaPáginaInicialParaAssistirAoVídeo() {
		logic = new AboutUsLogic();
		logic.startNavigation();
	}

	@Quando("clico no link About us")
	public void clicoNoLinkAboutUs() {
		logic.goToAboutUs();
	}

	@Quando("clico no botão play")
	public void clicoNoBotãoPlay() {
		logic.playVideo();
	}

	@Então("o elemento que representa o vídeo é exibido")
	public void oElementoQueRepresentaOVídeoÉExibido() {
		Assert.assertTrue(logic.isVideoElementVisible());
	}

}
