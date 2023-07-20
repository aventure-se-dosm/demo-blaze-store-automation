package business.add_to_cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import business.add_to_cart.AddProductToCartModel.ListGroupProductCategory;
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

	@FindAll(@FindBy(xpath = "//h4/a[@class = 'hrefch']"))
	private List<WebElement> lblProductTitle;

	@FindBy(xpath = "//a[@class='hrefch']/..")
	private WebElement selectedProduct;
	@FindBy(xpath = "//a[.='Add to cart']")
	private WebElement btnAddToCard;

	@FindBy(id = "tbodyid")
	private WebElement productTbody;

	@FindBy(id = "nava")
	private WebElement navBarHomePage;

	@FindBy(css = ".name")
	private WebElement productTitle;

	@FindBy(css = ".price-container")
	private WebElement productPrice;

	@FindBy(id = "cartur")
	WebElement cartLink;

	@FindBy(id = "cat")
	WebElement categoryMenu;

	public WebElement getNavBarHomePage() {
		return navBarHomePage;
	}

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

	List<WebElement> getCategoryMenuSeparatedElements() {
		return categoryMenuItems;
	}

	public WebElement getCategoryMenu() {
		return categoryMenu.findElement(By.xpath("./.."));
	}

	WebElement getCategory(ListGroupProductCategory category) {
		WebElement elem = getCategoryMenuSeparatedElements().stream()
				.filter(e -> e.getText().trim().equals(category.getCapitalizedName())).findFirst().get();
		return elem;
	}

	List<WebElement> getProductList() {
		return lblProductTitle;
	}

	WebElement getProductByTrademark(String trademark) {
		WebElement elem = getProductList().stream().filter(e -> e.getText().trim().contains(trademark)).findFirst().get();
		return elem;
	}

	protected WebElement getLoginModalDiv() {

		return loginModalDiv;
	}

	WebElement getTxtPassword() {
		return this.txtPassword;
	}

	WebElement getTxtUsername() {
		return this.txtUsername;
	}

	public WebElement getSigninLink() {
		return this.signinLink;
	}

	public WebElement getSelectedProduct() {
		return this.selectedProduct;
	}

	public WebElement getBtnAddToCart() {
		return this.btnAddToCard;
	}

	public WebElement getProductTbody() {
		return this.productTbody;
	}

	public WebElement getProductTitle() {
		return this.productTitle;
	}

	public WebElement getProductPrice() {
		return this.productPrice;
	}

	public WebElement getProductTableTitle(String title) {
		return getProductTbody().findElement(By.xpath(".//td[.='" + title + "']"));
	}

	public WebElement getProductTablePrice(String price) {
		return getProductTbody().findElement(By.xpath(".//td[.='" + price + "']"));
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getCategory(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
