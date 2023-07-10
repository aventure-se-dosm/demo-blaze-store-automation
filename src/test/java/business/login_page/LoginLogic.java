package business.login_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class LoginLogic {

	LoginPage loginPage;
	protected PageActions actions;
	private LoginModel loginModel;

	// A ROW NÃO DEV EFAZER PARTE DA LOGIC
	// QUE A MODEL SE VIRE PRA OBTÊ-LA E SE FAZER!
	// private Row currentRow;

	public LoginLogic() {
		setupLoginLogic();
	}

	public void setupLoginLogic() {
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

//	private void setRow() {
//		this.currentRow = TestContext.getRowByTaggedIdSheet();
//	}

	private void setLoginModel() {
		this.loginModel = new LoginModel();
	}

	LoginModel getModel() {
		return loginModel;
	}

	private void setPage() {
		this.loginPage = new LoginPage();
	}

	private LoginPage getLoginPage() {
		return loginPage;
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	public void startNavigation() {
		setupLoginLogic();
		actions.getUrl(TestContext.getConfigReader().getHomePage());
	}

	public String startLogin() {
		WebElement loginButton = getLoginPage().getLoginLink();
		String linkText = loginButton.getText();
		actions.click(loginButton);
		return linkText;
	}

	public void preencherUsuarioLogin() {
		String name = loginModel.getUsername();
		// TODO: value gotten from the proper Sheet!
		actions.write(getLoginPage().getTxtUsername(), name);
	}

	public void preencherSenhaLogin() {
		String password = loginModel.getPassword();
		// TODO: value got from the proper Sheet!
		actions.write(getLoginPage().getTxtPassword(), password);

	}

	void submeterFormularioLogin() {
		actions.click(getLoginPage().getLoginForm());
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public boolean isUserProperlyLogged() {
		String txtWelcome = actions.getText(getLoginPage().getlblWelcomeUser());
		boolean assertBool = txtWelcome.contains("mmm");
		return assertBool;
	}

	public void sendLoginForm() {
		actions.click(getLoginPage().getBtnEntrar());
	}
}
