package business.add_to_cart;

import org.openqa.selenium.By;

import business.add_to_cart.AddProductToCartModel.ListGroupProductCategory;
import core.actions.PageActions;
import core.utils.enums.ScenarioContextKeys;
import model.ProductDtoModel;
import test.context.TestContext;

public class AddToCartProductLogic {

	private AddProductToCartPage page;
	private AddProductToCartModel model;
	private PageActions actions;

	private final String ALERT_PRODUCT_ADDED = "Product added.";

	AddToCartProductLogic() {
		setupActions();
		setupPage();
		setupModel();
	}

	private void setupActions() {
		this.actions = new PageActions();
	}

	private void setupModel() {
		this.model = new AddProductToCartModel();
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
		actions.click(getPage().getBtnAddToCart());
		actions.getWait().untilPageLoadComplete();
		return actions.getAlertText().equals(ALERT_PRODUCT_ADDED);
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

	public void selectCategory(ListGroupProductCategory category) {
		actions.getWait().elementIsClickable(getPage().getCategoryMenu());
		actions.click(getPage().getCategory(category));
		actions.getWait().untilJqueryIsDone();
	}

	public void goToHomePage() {
		actions.click(getPage().getNavBarHomePage());
	}

	public void selectCategory() {
		selectCategory(ListGroupProductCategory.valueOf(model.getCategory().toUpperCase()));
	}

	
	
	public void saveCartFinalTotalValue() {
		TestContext.getScenarioContext().comuputeKey(ScenarioContextKeys.FINAL_CART_VALUE,
				actions.getText(getPage().getLblCartTotal()));
	}
	
	public void saveCartTotalValue() {
		TestContext.getScenarioContext().comuputeKey(ScenarioContextKeys.INITIAL_CART_VALUE,
				actions.getText(getPage().getLblCartTotal()));
	}

	public Integer getInitialCartTotalValue() {
		return Integer.parseInt(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.INITIAL_CART_VALUE));
	}
	
	public Integer getFinalCartTotalValue() {
		return Integer.parseInt(TestContext.getScenarioContext().getStringValue(ScenarioContextKeys.FINAL_CART_VALUE));
	}

}