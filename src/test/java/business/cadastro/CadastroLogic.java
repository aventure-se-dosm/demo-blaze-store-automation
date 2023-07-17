package business.cadastro;

import org.openqa.selenium.Alert;

import core.actions.PageActions;
import test.context.TestContext;

public class CadastroLogic {

	private CadastroPage cadastroPage;
	private PageActions actions;
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

	public void startCadastro() {
		actions.click(getCadastroPage().getCadastroLink());
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
		return TestContext.getDriver().getCurrentUrl();
	}

	public boolean isUserSignedUp() {
		String alertMessage;
		try {
			alertMessage = actions.getAlertText();
			return alertMessage.equals(getCadastroPage().getMsgSignupSuccess());
		} catch (RuntimeException e) {
			return false;
		}
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
