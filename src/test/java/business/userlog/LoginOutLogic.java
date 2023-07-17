package business.userlog;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import business.userlog.logout.LogoutModel;
import business.userlog.logout.LogoutPage;
import business.userlog.logout.LogoutModel.LoginAttributes;
import core.actions.PageActions;
import test.context.TestContext;

public class LoginOutLogic {

	protected PageActions actions;
	private LogoutModel logoutModel;
	LogoutPage logoutPage;

	public LoginOutLogic() {
		setupLogoutLogic();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	protected LogoutPage getLogoutPage() {
		return logoutPage;
	}

	protected LogoutModel getModel() {
		return logoutModel;
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	public boolean isUserProperlyLoggedIn() {
		String txtWelcome = actions.getText(getLogoutPage().getlblWelcomeUser());
		return txtWelcome.contains(getModel().getUsername());
	}

	public boolean isUserProperlyLoggedOut() {
		return actions.isEachWebElementPresent(getLogoutPage().getLoginLink(), getLogoutPage().getSigninLink());
	}

	public void preencherSenhaLogin() {

		actions.write(getLogoutPage().getTxtPassword(), getLogoutPage().getLoginModalDiv(), logoutModel.getPassword());
	}

	public void preencherUsuarioLogin() {

		actions.write(getLogoutPage().getTxtUsername(), getLogoutPage().getLoginModalDiv(), logoutModel.getUsername());
	}

	public void sendLoginForm() {
		actions.click(getLogoutPage().getBtnEntrar());
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	private void setLoginModel() {

		Row row = TestContext.getRowByTaggedIdSheet();
		this.logoutModel = new LogoutModel(row.getCell(LoginAttributes.USERNAME.index).getStringCellValue(),
				row.getCell(LoginAttributes.PASSWORD.index).getStringCellValue());
		row = null;
	}

	private void setPage() {
		this.logoutPage = new LogoutPage();
	}

	public void setupLogoutLogic() {
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

	public String startLogin() {
		WebElement loginButton = getLogoutPage().getLoginLink();
		String linkText = loginButton.getText();
		actions.click(loginButton);
		return linkText;
	}

	public void startNavigation() {
		setupLogoutLogic();
		actions.getUrl(TestContext.getConfigReader().getHomePage());
	}

	void submitFormularioLogin() {
		actions.click(getLogoutPage().getBtnEntrar());
	}

}
