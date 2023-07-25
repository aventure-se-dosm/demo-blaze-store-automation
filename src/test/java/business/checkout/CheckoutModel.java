package business.checkout;

import org.apache.commons.lang3.StringUtils;

public class CheckoutModel {

	
	private String txtFullName;
	private String txtCountry;
	private String txtccNumber;
	private String txtccExMonth;
	private String txtccExYear;

	public CheckoutModel() {
		setupRandomData();
	}

	private void setupRandomData() {
		this.txtFullName = "";
		
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

	public String getTxtccNumber() {
		// TODO Auto-generated method stub
		return this.txtccNumber;
	}

	public String getTxtccExMonth() {
		// TODO Auto-generated method stub
		return this.txtccExMonth;
	}

	public String getTxtccExYear() {
		// TODO Auto-generated method stub
		return this.txtccExYear;
	}

}
