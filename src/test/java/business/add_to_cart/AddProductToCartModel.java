package business.add_to_cart;

import org.apache.commons.lang3.StringUtils;

public class AddProductToCartModel {

	public AddProductToCartModel() {

	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}
	}

}
