package business.add_to_cart;

import org.apache.commons.lang3.StringUtils;

public class AddProductToCartModel {

	private String category;

	public AddProductToCartModel() {
		setCategory(category);
	}

	private void setCategory(String category) {
		this.category = category;
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

		PRODUCT_CATEGORY(2), FIRST_PRODUCT_CATEGORY(2), PRODUCT_BRAND(3), USERNAME(0), PASSWORD(1),
		SECOND_PRODUCT_CATEGORY(3);
		int index;

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

	String getCategory() {
		return this.category;
	}

}
