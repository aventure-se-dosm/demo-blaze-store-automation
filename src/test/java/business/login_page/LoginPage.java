package business.login_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class LoginPage {

	@FindBy(id = "login2")
	private WebElement loginLink;
	@FindBy(id = "loginusername")
	private WebElement txtUsername;
	@FindBy(id = "loginusername")
	private WebElement txtPassword;

	// aparentemente A MELHOR solução
	@FindBy(id = "loginpassword")
	private WebElement btnEntrar;

	// aparentemente NÃO compensa
	@FindBy(xpath = "//div[@id='logInModal']//form")
	private WebElement loginForm;

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
		return loginForm;
	}

}
