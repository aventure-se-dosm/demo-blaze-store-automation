package business.login;


import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class LoginLogic {

	LoginPage loginPage;
	protected PageActions actions;
	private LoginModel loginModel;

	public LoginLogic() {
		setupLoginLogic();
	}

	public void setupLoginLogic() {
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

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
		actions.getWait().untilPageLoadComplete();
		String name = loginModel.getUsername();	
		actions.write(getLoginPage().getTxtUsername(), getLoginPage().getLoginModalDiv(), name);
	}

	public void preencherSenhaLogin() {
		String password = loginModel.getPassword();
		actions.write(getLoginPage().getTxtPassword(), getLoginPage().getLoginModalDiv(), password);
	}


	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public boolean isUserProperlyLoggedIn() {
		actions.getWait().untilPageLoadComplete();
		String txtWelcome = actions.getText(getLoginPage().getlblWelcomeUser());
		boolean assertBool = txtWelcome.contains(getModel().getUsername());
		return assertBool;
	}

	public void sendLoginForm() {
		actions.click(getLoginPage().getBtnEntrar());
		actions.getWait().untilJqueryIsDone();
		actions.getWait().untilPageLoadComplete();
		
	}
}
