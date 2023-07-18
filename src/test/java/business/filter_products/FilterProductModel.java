package business.filter_products;

import org.apache.commons.lang3.StringUtils;

public class FilterProductModel {

	private String brand;
	private String category;

	public FilterProductModel(String category, String brand) {
		setCategory(category);
		setBrand(brand);
	}

	private void setBrand(String brand) {
		this.brand = brand;
	}

	private void setCategory(String category) {
		this.category = category;
	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}
	}

	enum FilterProducAtttributes {
		
		PRODUCT_CATEGORY(2), PRODUCT_BRAND(3),
		USERNAME(0), PASSWORD(1);
		int index;
		
		FilterProducAtttributes(int index) {
			this.index = index;
		}

		int getIndex() {
			return this.index;
		}
	}
	

	String getBrand() {
		return this.brand;
	}

	String getCategory() {
		return this.category;
	}

}
