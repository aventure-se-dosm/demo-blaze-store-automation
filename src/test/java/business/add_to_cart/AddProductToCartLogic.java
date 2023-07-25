package business.add_to_cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import business.step_classes.Logic;
import core.actions.PageActions;
import core.utils.enums.ScenarioContextKeys;
import model.ProductDtoModel;
import test.context.TestContext;
import test_enums.Attributes.FilterProductAtttributes;

public class AddProductToCartLogic extends Logic {

	private AddProductToCartPage page;
	private AddProductToCartModel model;
	private PageActions actions;

	private final String ALERT_PRODUCT_ADDED = "Product added.";

	public AddProductToCartLogic() {
		setupActions();
		setupPage();
		setupModel();
	}

	private void setupActions() {
		this.actions = new PageActions();
	}

	private void setupModel() {
		this.setModel(new AddProductToCartModel());
	}

	private void setupPage() {
		this.page = new AddProductToCartPage();
	}

	private AddProductToCartPage getPage() {
		return this.page;
	}

	private PageActions getActions() {
		return this.actions;
	}

	public void clickOnTheFirstProduct() {
		getActions().click(getPage().getSelectedProduct());
	}

	public boolean addProductToCart() {
		actions.getWait().untilPageLoadComplete();
		actions.click(getPage().getBtnAddToCart());
		String message = actions.getAlertText();
		return message.equals(ALERT_PRODUCT_ADDED);
	}

	private ProductDtoModel getProductDtoModel() {
		return new ProductDtoModel(actions.getText(getPage().getProductTitle()),
				actions.getText(getPage().getProductPrice()));
	}

	public void saveCtxProductInfos() {
		TestContext.getScenarioContext().comuputeKey(ScenarioContextKeys.SINGLE_PRODUCT_ID_0008, getProductDtoModel());
	}


	public boolean isTheProductAddedToTheCart() {
		ProductDtoModel pdto = (ProductDtoModel) TestContext.getScenarioContext()
				.getValue(ScenarioContextKeys.SINGLE_PRODUCT_ID_0008);
		return actions.getWait().elementIsVisible(page.getProductTbody()
				.findElement(By.xpath(".//td[.='" + pdto.getProductTitle() + "']/../td[.='" + pdto.getPrice() + "']")));
	}

	public void goToNavBar() {

		actions.click(getPage().getCartLink());
	}

	public void selectCategory(FilterProductAtttributes categoria) {
		TestContext.getDriver().navigate().refresh();
		actions.getWait().untilPageLoadComplete();
		actions.getWait().elementIsVisible(getPage().getCategoryMenu());
		actions.click(getPage().getCategory(getValue(categoria.getIndex())));
		getActions().getWait().jsFinishedSuccessifully();

	}

	public void selectCategory() {
		selectCategory(FilterProductAtttributes.CATEGORIA);
	}

	public AddProductToCartModel getModel() {
		return model;
	}

	private void setModel(AddProductToCartModel model) {
		this.model = model;
	}

	public void goToHomePage() {
		getActions().click(getPage().getHomePageLink());
		getActions().getWait().untilPageLoadComplete();

	}

	public void deleteAddedProduct() {
		deleteAddedProduct(0);
		
	}

	public void deleteAddedProduct(Integer index) {
		getActions().getWait().untilJqueryIsDone();
		TestContext.getScenarioContext().comuputeKey(ScenarioContextKeys.DELETED_CART_PRODUCT,
				getPage().getAddedCartProductDeleteLinks().get(index));
		actions.click(getPage().getAddedCartProductDeleteLinks().get(index));
		getActions().getWait().untilPageLoadComplete();
		getActions().getWait().untilJqueryIsDone();

	}

	public void deleteAddedProduct(WebElement elem) {
		// TestContext.getDriver().navigate().refresh();
		actions.click(elem);
		getActions().getWait().untilJqueryIsDone();

	}

	public boolean isAddedProductRemoved() {

		getActions().getWait().untilPageLoadComplete();
		// actions.click((WebElement)TestContext.getScenarioContext().getValue(ScenarioContextKeys.DELETED_CART_PRODUCT));
		return getActions().isWebElementNotPresent(
				(WebElement) TestContext.getScenarioContext().getValue(ScenarioContextKeys.DELETED_CART_PRODUCT));
	}

	public boolean isCartEmpty() {
		deleteAddedProducts();
	return getActions().isEachWebElementNotPresent(getPage().getAddedCartProductDeleteLinks());
	}

	public void deleteAddedProducts() {
		while (true) {
			try {
				getActions().click(getPage().getAddedCartProductDeleteLink(0));
			} catch (Exception  sreexc) {
				break;
			}

		}

	}
}