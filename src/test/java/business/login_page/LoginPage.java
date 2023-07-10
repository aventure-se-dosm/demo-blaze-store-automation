package business.login_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class LoginPage {

	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement btnEntrar;
	@FindBy(id = "nameofuser")
	private WebElement lblWelcomeUser;
	@FindBy(id = "login2")
	private WebElement loginLink;
	@FindBy(id = "loginpassword")
	private WebElement txtPassword;

	@FindBy(id = "loginusername")
	private WebElement txtUsername;

	public LoginPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	WebElement getBtnEntrar() {
		return btnEntrar;
	}

	public WebElement getlblWelcomeUser() {
		return this.lblWelcomeUser;
	}

	WebElement getLoginLink() {
		return loginLink;
	}

	WebElement getTxtPassword() {
		return txtPassword;
	}


	WebElement getTxtUsername() {
		return txtUsername;
	};
}
