package business.login_page;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class LoginLogic {

	LoginPage loginPage;
	protected PageActions actions;
	private LoginModel loginModel;
	private Row currentRow;

	public LoginLogic() {
		setupLoginLogic();
	}

	public void setupLoginLogic() {
		setPage();
		setActions(new PageActions());
		setRow();
		setLoginModel();
	}

	private void setRow() {
		this.currentRow = TestContext.getRowByTaggedIdSheet();
	}

	private void setLoginModel() {
		
		//TODO: Attribute index: either by enum, or search!
		this.loginModel = new LoginModel(
				getCurrentRow().getCell(0).getStringCellValue(),
				getCurrentRow().getCell(1).getStringCellValue());
	}

	LoginModel getModel() {
		return loginModel;
	}

	private void setPage() {
		this.loginPage = new LoginPage();
	}

	private Row getCurrentRow() {
		return this.currentRow;
	}

	private LoginPage getHomePage() {
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
		WebElement loginButton = getHomePage().getLoginLink();
		String linkText = loginButton.getText();
		actions.click(loginButton);
		return linkText;
	}

	public void preencherUsuarioLogin() {
		String name = "mmm";
		// TODO: value gotten from the proper Sheet!
		actions.write(getHomePage().getTxtUsername(), name);
	}

	public void preencherSenhaLogin() {
		String password = "mmm";
		// TODO: value got from the proper Sheet!
		actions.write(getHomePage().getTxtPassword(), password);

	}

	void submeterFormularioLogin() {
		actions.click(getHomePage().getLoginForm());
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public boolean isUserProperlyLogged() {
		String txtWelcome = actions.getText(getHomePage().getlblWelcomeUser());
		boolean assertBool = txtWelcome.contains("mmm");
		return assertBool;
	}

	public void sendLoginForm() {
		actions.click(getHomePage().getBtnEntrar());
	}
}
