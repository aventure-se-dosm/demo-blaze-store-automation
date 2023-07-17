package business.userlog.login;

import business.userlog.LoginOutLogic;
import core.actions.PageActions;

public class LoginLogic extends LoginOutLogic {

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

}
