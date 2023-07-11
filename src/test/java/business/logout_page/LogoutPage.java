package business.logout_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class LogoutPage {
	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement btnEntrar;

	@FindBy(id = "nameofuser")
	private WebElement lblWelcomeUser;

	@FindBy(id = "login2")
	private WebElement loginLink;

	@FindBy(id = "signin2")
	private WebElement signinLink;

	@FindBy(xpath = "//div[@id='logInModal']/div")
	private WebElement loginModalDiv;

	@FindBy(id = "loginpassword")
	private WebElement txtPassword;

	@FindBy(id = "loginusername")
	private WebElement txtUsername;

	@FindBy(id = "logout2")
	private WebElement logoutLink;

	public LogoutPage() {
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

	WebElement getLogoutLink() {
		return logoutLink;
	}

	protected WebElement getLoginModalDiv() {
		return loginModalDiv;
	}

	WebElement getTxtPassword() {
		return txtPassword;
	}

	WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getSigninLink() {
		return signinLink;
	};

}
