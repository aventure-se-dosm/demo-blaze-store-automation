package business.checkout;

import org.apache.commons.lang3.StringUtils;

public class CheckoutModel {

	private String txtFullName = "Chris Rock";
	private String txtCountry = "US";
	private String txtCity = "Dakota";
	private String txtccNumber = "3784958327195306";
	private String txtccExMonth = "12";
	private String txtccExYear = "2030";

	public CheckoutModel() {
		// setupRandomData();
	}

	private void setupRandomData() {

	}

	enum ListGroupProductCategory {
		PHONES, LAPTOPS, MONITORS;
		String getExibitionCategoryString() {
			return StringUtils.capitalize(this.name());
		}
	}

	public String getTxtFullName() {
		
		return this.txtFullName;
	}

	public String getTxtCountry() {
		
		return this.txtCountry;
	}

	public String getTxtCity() {
		
		return this.txtCity;
	}

	public String getTxtCcNumber() {
		
		return this.txtccNumber;
	}

	public String getTxtCcExMonth() {
		
		return this.txtccExMonth;
	}

	public String getTxtCcExYear() {
		
		return this.txtccExYear;
	}

}
