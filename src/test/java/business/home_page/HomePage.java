package business.home_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id = "login2")
	WebElement loginLink;
	@FindBy(id = "loginusername")
	WebElement txtUser;
	@FindBy(id = "loginusername")
	WebElement txtPassword;
	@FindBy(id = "loginpassword")
	WebElement btnEntrar;

	public HomePage() {
		setLoginLink(loginLink);
		setBtnEntrar(btnEntrar);
		setTxtPassword(txtPassword);
		setTxtUser(txtUser);
	}

	WebElement getLoginLink() {
		return loginLink;
	}

	private void setLoginLink(WebElement loginLink) {
		this.loginLink = loginLink;
	}

	WebElement getTxtUser() {
		return txtUser;
	}

	private void setTxtUser(WebElement txtUser) {
		this.txtUser = txtUser;
	}

	WebElement getTxtPassword() {
		return txtPassword;
	}

	private void setTxtPassword(WebElement txtPassword) {
		this.txtPassword = txtPassword;
	}

	WebElement getBtnEntrar() {
		return btnEntrar;
	}

	private void setBtnEntrar(WebElement btnEntrar) {
		this.btnEntrar = btnEntrar;
	}
}
