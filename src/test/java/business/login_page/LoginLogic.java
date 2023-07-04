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

	// se o pico reclamar
	// tira o construtor
	public LoginLogic() {
		setupLoginLogic();
	}

	public void setupLoginLogic() {
		setPage();
		setActions(new PageActions());
		setRow();
//		setLoginModel();
	}

	private void setRow() {
		this.currentRow = TestContext.getRowByTaggedIdSheet();
	}

	private void setLoginModel() {
		this.loginModel = new LoginModel(getCurrentRow().getCell(0).getStringCellValue(),
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

	private LoginPage getPage() {
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
		WebElement loginButton = getPage().getBtnEntrar();
		String linkText = loginButton.getText();
		actions.click(loginButton);
		return linkText;
	}

	public void preencherUsuarioLogin(LoginModel loginModel) {
		actions.write(getPage().getTxtUsername(), getModel().getUsername());
	}

	public void preencherSenhaLogin(LoginModel loginModel) {
		actions.write(getPage().getTxtPassword(), "mmm");

	}

	void submeterFormularioLogin() {
		actions.submitForm(getPage().getLoginForm());
	}

//vamos ver se depois vamos abstrair Logic ou não!
	boolean isLoginBemSucedido() {
		return false;
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public boolean isUserProperlyLogged() {

		return false;
	}

}
