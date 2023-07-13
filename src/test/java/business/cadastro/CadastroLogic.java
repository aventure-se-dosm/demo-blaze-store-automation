package business.cadastro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class CadastroLogic {

	CadastroPage cadastroPage;
	protected PageActions actions;
	private CadastroModel cadastroModel;

	public CadastroLogic() {
		setupCadastroLogic();
	}

	public void setupCadastroLogic() {
		setPage();
		setActions(new PageActions());
		setCadastroModel();
	}

	private void setCadastroModel() {
		this.cadastroModel = new CadastroModel();
	}

	CadastroModel getModel() {
		return cadastroModel;
	}

	private void setPage() {
		this.cadastroPage = new CadastroPage();
	}

	private CadastroPage getCadastroPage() {
		return cadastroPage;
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	public void startNavigation() {
		setupCadastroLogic();
		actions.getUrl(TestContext.getConfigReader().getHomePage());
	}

	public String startCadastro() {
		WebElement cadastroButton = getCadastroPage().getCadastroLink();
		String linkText = cadastroButton.getText();
		actions.click(cadastroButton);
		return linkText;
	}

	public void preencherUsuarioCadastro() {
		preencherUsuarioCadastro(cadastroModel.getUsername());
	}

	public void preencherUsuarioCadastro(String name) {
		actions.write(getCadastroPage().getTxtUsername(), getCadastroPage().getCadastroModalDiv(), name);
	}

	public void preencherSenhaCadastro(String password) {
		actions.write(getCadastroPage().getTxtPassword(), getCadastroPage().getCadastroModalDiv(), password);
	}
	public void preencherSenhaCadastro() {
		preencherSenhaCadastro(cadastroModel.getPassword());
	}
	

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public boolean isUserSignedUp() {
		Alert alert = actions.getWait().alertIsPresent();
		if (alert == null)
			return false;

		boolean isUserSigned = alert.getText().equals(getCadastroPage().getMsgSignupSuccess());
		alert.accept();
		return isUserSigned;
	}

	public void sendCadastroForm() {
		actions.click(getCadastroPage().getBtnEntrar());
	}

	public boolean isUserAlreadyExistent() {
		Alert alert = actions.getWait().alertIsPresent();
		if (alert == null)
			return false;

		boolean isUserAlreadyExistent = alert.getText().equals(getCadastroPage().getMsgUserAlreadyExists());
		alert.accept();
		return isUserAlreadyExistent;
	}


}
