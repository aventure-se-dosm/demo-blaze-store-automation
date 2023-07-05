package business.login_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class LoginPage {

	@FindBy(id = "login2")
	private WebElement loginLink;
	
	//loginform
	@FindBy(id = "loginusername")
	private WebElement txtUsername;
	@FindBy(id = "loginpassword")
	private WebElement txtPassword;

	
	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement btnEntrar;

	//loggedUserHomePage
	@FindBy(id = "nameofuser")
	private WebElement lblWelcomeUser;

	public WebElement getlblWelcomeUser() {
		return this.lblWelcomeUser;
	};
	

	public LoginPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	WebElement getLoginLink() {
		return loginLink;
	}

	WebElement getTxtUsername() {
		return txtUsername;
	}

	WebElement getTxtPassword() {
		return txtPassword;
	}

	WebElement getBtnEntrar() {
		return btnEntrar;
	}


	public WebElement getLoginForm() {
		// TODO Auto-generated method stub
		return null;
	}

//	public WebElement getLoginForm() {
//		return this.loginForm;
//	}

}
