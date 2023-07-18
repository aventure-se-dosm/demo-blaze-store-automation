package business.filter_products;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import business.filter_products.FilterProductModel.FilterProducAtttributes;
import core.actions.PageActions;
import test.context.TestContext;

public class FilterProductLogic {

	protected PageActions actions;
	private FilterProductModel filterProductModel;
	FilterProductPage filterProductPage;

	public FilterProductLogic() {
		setupFilterProductLogic();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	private FilterProductPage getFilterProductPage() {
		return filterProductPage;
	}

	FilterProductModel getModel() {
		return filterProductModel;
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	public boolean isThereAtLeastOneProductOfTheGivenBranch() {

		WebElement targetProduct = getFilterProductPage().getProductByBrand(getModel().getBrand());

		actions.scrollIntoView(targetProduct);
		return actions.getWait().elementIsVisible(targetProduct);
	}

	public void selectCategory() {
		try {
			Thread.sleep(3000);
		
			actions.click(filterProductPage.getCategory(getModel().getCategory()));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sendLoginForm() {
		actions.click(getFilterProductPage().getBtnEntrar());
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	private void setLoginModel() {

		Row row = TestContext.getRowByTaggedIdSheet();
		this.filterProductModel = new FilterProductModel(
				row.getCell(FilterProducAtttributes.PRODUCT_CATEGORY.getIndex()).getStringCellValue(),
				row.getCell(FilterProducAtttributes.PRODUCT_BRAND.getIndex()).getStringCellValue());
		row = null;
	}

	private void setPage() {
		this.filterProductPage = new FilterProductPage();
	}

	public void setupFilterProductLogic() {
		setPage();
		setActions(new PageActions());
		setLoginModel();
	}

}
