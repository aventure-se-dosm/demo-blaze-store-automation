package business.filter_products;

import org.apache.commons.lang3.StringUtils;

public class FilterProductModel {

	private String trademark;
	private String category;

	public FilterProductModel(String category, String trademark) {
		setCategory(category);
		setTrademark(trademark);
	}

	private void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	private void setCategory(String category) {
		this.category = category;
	}

	String getTrademark() {
		return this.trademark;
	}

	String getCategory() {
		return this.category;
	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}
	}

	enum FilterProducAtttributes {
		PRODUCT_CATEGORY(2), PRODUCT_BRAND(3), USERNAME(0), PASSWORD(1);
		
		int index;
		FilterProducAtttributes(int index) {
			this.index = index;
		}

		int getIndex() {
			return this.index;
		}
	}

}
