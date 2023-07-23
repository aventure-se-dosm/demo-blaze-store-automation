package business.add_to_cart;

import org.openqa.selenium.By;

import business.step_classes.Logic;
import core.actions.PageActions;
import core.utils.enums.ScenarioContextKeys;
import model.ProductDtoModel;
import test.context.TestContext;
import test_enums.Attributes.FilterProductAtttributes;

public class AddToCartProductLogic extends Logic {

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
		actions.click(getPage().getBtnAddToCart());
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
				.findElement(By.xpath("//td[.='" + pdto.getProductTitle() + "']/../td[.='" + pdto.getPrice() + "']")));
	}

	public void goToNavBar() {

		actions.click(getPage().getCartLink());
	}

	public void selectCategory(String category) {
		actions.getWait().elementIsVisible(getPage().getCategoryMenu());
		actions.click(getPage().getCategory(category));
		getActions().getWait().jsFinishedSuccessifully();

	}

	public void selectCategory() {
		TestContext.getDriver().navigate().refresh();
		String s = getValue(FilterProductAtttributes.CATEGORIA.getIndex());
		selectCategory(s);
		

	}

	public AddProductToCartModel getModel() {
		return model;
	}

	private void setModel(AddProductToCartModel model) {
		this.model = model;
	}

}
