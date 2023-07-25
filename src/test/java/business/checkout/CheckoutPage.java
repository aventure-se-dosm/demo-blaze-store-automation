package business.checkout;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class CheckoutPage {
	@FindBy(id = "name")
	private WebElement txtFullName;
	@FindBy(id = "city")
	private WebElement TxtCity;
	@FindBy(id = "country")
	private WebElement txtCountry;
	@FindBy(id = "card")
	private WebElement txtCardNumber;
	@FindBy(id = "month")
	private WebElement txtCardMonth;
	@FindBy(id = "year")
	private WebElement txtCardYear;
	@FindBy(id = "nava")
	private WebElement HomePageLink;

	@FindBy(xpath = "//button[@data-target='#orderModal']")
	private WebElement btnPlaceOrder;

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

	@FindBy(css = ".name")
	private WebElement productTitle;

	@FindBy(css = ".price-container")
	private WebElement productPrice;

	@FindBy(id = "cartur")
	WebElement cartLink;

	@FindBy(xpath = "//a[@id='cat']")
	private WebElement categoryMenu;

	@FindBys(@FindBy(xpath = "//a[contains(@onclick,'delete')]"))
	private List<WebElement> addedCartProductDeleteLinks;
	@FindBy(xpath = "//button[@onclick='purchaseOrder()']")
	private WebElement btnPurchaseOrder;
	@FindBy(css = "p.lead.text-muted")
	private WebElement finishedOrderFetails;
	
	@FindBy(xpath = "//h2[.='Thank you for your purchase!']")
	private WebElement lblThankYouForYourPurchase;
	@FindBy(css = "button.confirm")
	private WebElement btnOrderFinishedOk;

	public CheckoutPage() {
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

	List<WebElement> getCategoryMenuItems() {
		return categoryMenuItems;
	}

	WebElement getCategory(String category) {
		WebElement w;
		w = getCategoryMenuItems().stream().filter(e -> e.getText().trim().startsWith(category)).findFirst().get();
		return w;
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
		return this.txtPassword;
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
		return cartLink.findElement(By.xpath("./.."));
	}

	WebElement getCategoryMenu() {
		return this.categoryMenu;

	}

	public WebElement getHomePageLink() {
		return this.HomePageLink;
	}

	public List<WebElement> getAddedCartProductDeleteLinks() {
		return this.addedCartProductDeleteLinks;
	}

	public WebElement getBtnPlaceOrder() {
		return this.btnPlaceOrder;
	}
	public WebElement getBtnPurchaseOrder() {
		return this.btnPurchaseOrder;
	}

	public WebElement getAddedCartProductDeleteLink(Integer index) {
		return getAddedCartProductDeleteLinks().get(index);
	}

	WebElement getTxtFullName() {
		return this.txtFullName;
	}

	public WebElement getTxtCountry() {
		return this.txtCountry;
	}

	public WebElement getTxtccNumber() {
		return this.txtCardNumber;
	}

	public WebElement getTxtccExMonth() {
		return this.txtCardMonth;
	}

	public WebElement getTxtccExYear() {
		return this.txtCardYear;
	}

	public WebElement getTxtCity() {
		return this.TxtCity;
	}

	public WebElement getFinishedOrderDetails() {
		// TODO Auto-generated method stub
		return this.finishedOrderFetails;
	}

	public WebElement getLblThankYouForPurchasing() {
		return this.lblThankYouForYourPurchase;
	}

	public WebElement getBtnOkOrderFinished() {
		// TODO Auto-generated method stub
		return this.btnOrderFinishedOk;
	}

}
