package business.addToCart;

import core.actions.PageActions;

public class AddToCartProductLogic {

	AddProductToCartPage page;
	AddProductToCartModel model;
	PageActions actions;

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
}