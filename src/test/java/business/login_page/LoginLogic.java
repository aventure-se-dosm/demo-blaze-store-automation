package business.login_page;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import core.actions.PageActions;
import test.context.TestContext;

public class LoginLogic {

	LoginPage loginPage;
	protected PageActions actions;
	private LoginModel loginModel;
	private Row currentRow;

	LoginLogic() {
		setupLoginLogic();
	}

	void setupLoginLogic() {
		setRow();
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

	private void setRow() {
		this.currentRow = TestContext.getRowByTaggedIdSheet();
	}

	private void setLoginModel() {
		this.loginModel = new LoginModel(
				getCurrentRow().getCell(0).getStringCellValue(),
				getCurrentRow().getCell(1).getStringCellValue()
			);
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

	// ok... mas passar da página pra cá...
	// como evitar tantos parâmetros?
	// hardcodado só pra ver se chega msm
	void preencherUsuarioLogin(LoginModel loginModel) {
		actions.write(getPage().getTxtUsername(), getModel().getUsername());
	}

	void preencherSenhaLogin(LoginModel loginModel) {
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
}
