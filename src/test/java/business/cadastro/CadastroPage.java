package business.cadastro;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class CadastroPage {

	@FindBy(xpath = "//button[@onclick='register()']")
	private WebElement btnEntrar;

	@FindBy(id = "nameofuser")
	private WebElement lblWelcomeUser;

	@FindBy(id = "signin2")
	private WebElement cadastroLink;

	@FindBy(id = "sign-password")
	private WebElement txtPassword;

	@FindBy(id = "sign-username")
	private WebElement txtUsername;

	@FindBy(xpath = "//div[@id='signInModal']/div")
	private WebElement cadastroModalDiv;
	
	private final String msgSignupSuccess = "Sign up successful.";
	private final String msgUserAlreadyExists = "This user already exist.";

	public CadastroPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	WebElement getBtnEntrar() {
		return btnEntrar;
	}

	public WebElement getlblWelcomeUser() {
		return this.lblWelcomeUser;
	}

	public WebElement getCadastroLink() {
		return this.cadastroLink;
	}

	public WebElement getTxtPassword() {
		return this.txtPassword;
	}

	public WebElement getTxtUsername() {
		return this.txtUsername;
	}

	public WebElement getCadastroModalDiv() {
		return this.cadastroModalDiv;
	};
	
	public String getMsgSignupSuccess() {
		return msgSignupSuccess;
	}
	
	public String getMsgUserAlreadyExists() {
		return msgUserAlreadyExists;
	}
	
	
}
