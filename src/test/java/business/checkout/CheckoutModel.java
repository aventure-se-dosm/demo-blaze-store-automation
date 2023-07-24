package business.checkout;

import org.apache.commons.lang3.StringUtils;

public class CheckoutModel {

	public CheckoutModel() {

	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}
	}

}
