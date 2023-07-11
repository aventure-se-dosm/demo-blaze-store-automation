package business.login_page;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import business.login_page.LoginModel.LoginAttributes;
import core.actions.PageActions;
import test.context.TestContext;

public class LoginLogic {

	protected PageActions actions;
	private LoginModel loginModel;
	LoginPage loginPage;

	public LoginLogic() {
		setupLoginLogic();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	private LoginPage getLoginPage() {
		return loginPage;
	}

	LoginModel getModel() {
		return loginModel;
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	public boolean isUserProperlyLogged() {
		String txtWelcome = actions.getText(getLoginPage().getlblWelcomeUser());
		return txtWelcome.contains(getModel().getUsername());
	}

	public void preencherSenhaLogin() {

		actions.write(getLoginPage().getTxtPassword(), getLoginPage().getLoginModalDiv(), loginModel.getPassword());
	}

	public void preencherUsuarioLogin() {

		actions.write(getLoginPage().getTxtUsername(), getLoginPage().getLoginModalDiv(), loginModel.getUsername());
	}

	public void sendLoginForm() {
		actions.click(getLoginPage().getBtnEntrar());
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	private void setLoginModel() {

		Row row = TestContext.getRowByTaggedIdSheet();
		this.loginModel = new LoginModel(row.getCell(LoginAttributes.USERNAME.index).getStringCellValue(),
				row.getCell(LoginAttributes.PASSWORD.index).getStringCellValue());
		row = null;
	}

	private void setPage() {
		this.loginPage = new LoginPage();
	}

	public void setupLoginLogic() {
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

	public String startLogin() {
		WebElement loginButton = getLoginPage().getLoginLink();
		String linkText = loginButton.getText();
		actions.click(loginButton);
		return linkText;
	}

	public void startNavigation() {
		setupLoginLogic();
		actions.getUrl(TestContext.getConfigReader().getHomePage());
	}

	void submitFormularioLogin() {
		actions.click(getLoginPage().getBtnEntrar());
	}
}
