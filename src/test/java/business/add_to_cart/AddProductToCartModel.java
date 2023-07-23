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

//	enum FilterProductAtttributes {
//
//		USERNAME(0),
//		PASSWORD(1),
//		PRODUCT_CATEGORY(2),
//		FIRST_PRODUCT_CATEGORY(2),
//		SECOND_PRODUCT_CATEGORY(3),
//		PRODUCT_BRAND(3);
//		int index;
//
//		FilterProductAtttributes(int index) {
//			this.index = index;
//		}
//
//		int getIndex() {
//			return this.index;
//		}
//	}

}
