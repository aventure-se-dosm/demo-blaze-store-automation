package business.model;

public class ProductModel {
	
	private Integer price;
	private String name;

	public ProductModel(Integer price, String name) {
		setName(name);
		setPrice(price);
	}

	private void setPrice(Integer price) {
		this.price = price;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
