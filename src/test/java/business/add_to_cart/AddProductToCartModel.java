package business.add_to_cart;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;

import test.context.TestContext;

public class AddProductToCartModel {

	private String category1, trademark1, category2;

	public AddProductToCartModel() {
		setCategory();
	}

	private void setCategory() {
		Row row = TestContext.getRowByTaggedIdSheet();
		this.category1 = row.getCell(FilterProducAtttributes.FIRST_PRODUCT_CATEGORY.getIndex()).getStringCellValue();
		this.trademark1 = row.getCell(FilterProducAtttributes.FIRST_PRODUCT_BRAND.getIndex()).getStringCellValue();
		this.category2 = row.getCell(FilterProducAtttributes.SECOND_PRODUCT_CATEGORY.getIndex()).getStringCellValue();
	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}

		String getCapitalizedName() {
			return StringUtils.capitalize(this.name().toLowerCase());
		}
	}

	enum FilterProducAtttributes {

		PRODUCT_CATEGORY(2), FIRST_PRODUCT_CATEGORY(2), FIRST_PRODUCT_BRAND(3), USERNAME(0), PASSWORD(1),
		SECOND_PRODUCT_CATEGORY(3);
		private int index;

		FilterProducAtttributes(int index) {
			this.index = index;
		}

		int getIndex() {
			return this.index;
		}

		String getCapitalizedName() {
			return StringUtils.capitalize(this.name().toLowerCase());
		}
	}

public String getCategory() {
		return this.category1;
	}
public String getCategory1() {
	return this.category1;
}

}
