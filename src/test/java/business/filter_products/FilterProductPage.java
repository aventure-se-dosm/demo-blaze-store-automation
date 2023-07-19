package business.filter_products;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class FilterProductPage {
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

	@FindBy(id = "tbodyid")
	private WebElement productItems;

	@FindBy(id = "itemc")
	private WebElement categoryMenuItem;

	@FindAll(@FindBy(id = "itemc"))
	private List<WebElement> categoryMenuItems;

	@FindAll(@FindBy(xpath = "//h4/a[@class = 'hrefch']/.."))
	private List<WebElement> lblProductTitles;

	@FindBy(xpath = "//h4/a[@class = 'hrefch']")
	private WebElement lblProductTitle;

	public FilterProductPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	WebElement getBtnEntrar() {
		return btnEntrar;
	}

	public WebElement getlblWelcomeUser() {
		return this.lblWelcomeUser;
	}

	/**
	 * @return the productItems
	 */
	public WebElement getProductItems() {
		return productItems;
	}

	WebElement getLoginLink() {
		return loginLink;
	}

	WebElement getCategoryMenuELement() {
		return categoryMenuItem;
	}

	List<WebElement> getCategoryMenuItems() {
		return categoryMenuItems;
	}

	WebElement getCategory(String category) {
		return getCategoryMenuItems().stream().filter(e -> e.getText().trim().startsWith(category)).findFirst().get();
	}

	List<WebElement> getProductList() {
		return lblProductTitles;
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
	};

}
