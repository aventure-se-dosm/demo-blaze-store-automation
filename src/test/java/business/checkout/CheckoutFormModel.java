package business.checkout;

import test.context.TestContext;

public class CheckoutFormModel {
	
	private String name, city, country, ccNumber, ccExpMonth, ccExpYear;
	
	CheckoutFormModel(){
		setForm();
	}
	
	private void setForm() {
		
		
	}

	/**
	 * @return the name
	 */
	String getName() {
		return this.name;
	}

	/**
	 * @return the city
	 */
	String getCity() {
		return this.city;
	}

	/**
	 * @return the country
	 */
	String getCountry() {
		return this.country;
	}

	/**
	 * @return the ccNumber
	 */
	String getCcNumber() {
		return this.ccNumber;
	}

	/**
	 * @return the ccExpMonth
	 */
	String getCcExpMonth() {
		return this.ccExpMonth;
	}

	/**
	 * @return the ccExpYear
	 */
	String getCcExpYear() {
		return ccExpYear;
	}

	public enum CheckoutFormIndex {
		NAME(4),
		CITY(5),
		COUNTRY(6),
		CREDIT_CARD_MUMBER(7),
		CREDIT_CARD_EXP_MONTH(8),
		CREDIT_CARD_EXP_YEAR(9);
		
		private Integer index;
		private CheckoutFormIndex(Integer index) {
			this.index = index;
		};
		
		Integer getIndex(){
			return this.index;
		}
		
	}
	

}
