package model;

public class ProductDtoModel {

	String description, price;

	public ProductDtoModel(String description, String price) {
		setProductTitle(description);
		setPrice(price);
	}

	public String getProductTitle() {
		return description;
	}

	public String getPrice() {
		return price;
	}

	private void setProductTitle(String productTitle) {
		this.description = productTitle;
	}

	private void setPrice(String price) {
		this.price = price.replaceAll("[^\\d]", "");
	}

}
