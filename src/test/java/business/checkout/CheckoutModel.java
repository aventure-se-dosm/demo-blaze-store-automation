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
		// TODO Auto-generated method stub
		return this.txtFullName;
	}

	public String getTxtCountry() {
		// TODO Auto-generated method stub
		return this.txtCountry;
	}

	public String getTxtCity() {
		// TODO Auto-generated method stub
		return this.txtCity;
	}

	public String getTxtCcNumber() {
		// TODO Auto-generated method stub
		return this.txtccNumber;
	}

	public String getTxtCcExMonth() {
		// TODO Auto-generated method stub
		return this.txtccExMonth;
	}

	public String getTxtCcExYear() {
		// TODO Auto-generated method stub
		return this.txtccExYear;
	}

}
