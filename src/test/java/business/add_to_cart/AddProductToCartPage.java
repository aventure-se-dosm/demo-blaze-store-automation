package business.add_to_cart;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class AddProductToCartPage {
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

	@FindAll(@FindBy(id = "itemc"))
	private List<WebElement> categoryMenuItems;

	@CacheLookup
	@FindAll(@FindBy(xpath = "//h4/a[@class = 'hrefch']"))
	private List<WebElement> lblProductTitle;

	@FindBy(xpath = "// a[@onclick='addToCart(10)']")
	private WebElement selectedProduct;

	public AddProductToCartPage() {
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

	List<WebElement> getCategoryMenu() {
		return categoryMenuItems;
	}

	WebElement getCategory(String category) {
		return getCategoryMenu().stream().filter(e -> e.getText().trim().startsWith(category)).findFirst().get();
	}

	List<WebElement> getProductList() {
		return lblProductTitle;
	}

	WebElement getProductByTrademark(String brand) {
		WebElement elem = getProductList().stream().filter(e -> e.getText().trim().contains(brand)).findFirst().get();
		return elem;
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
	}

	public WebElement getSelectedProduct() {
		return selectedProduct;
	}

}
