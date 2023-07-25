package business.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.w3c.dom.ranges.RangeException;

public class RandomDataGenerator {
	
	private enum RandomDataTypes {
		NAME(),
		SURNAME(),
		LAST_NAME(),
		FULL_NAME(),
		CITY(),
		COUNTRY(),
		CREDIT_CARD(),
		CREDIT_CARD_NUMBER(),
		CREDIT_CARD_EXP_MONTH(),
		CREDIT_CARD_EXP_YEAR();
	}
	
	public String GenerateRandomData(RandomDataTypes RandomDataType) {
		switch (RandomDataType) {
		case NAME: return generateRandomFirstName();
		case SURNAME: case LAST_NAME: return generateRandomSurname();
		case FULL_NAME: return generateFullName();
		case CITY: return generateCity();
		case COUNTRY: return selectCountry();
		case CREDIT_CARD: return generateCreditCard();
		case CREDIT_CARD_NUMBER: return generateCreditCardNumber();
		case CREDIT_CARD_EXP_MONTH: return generateCreditCardExpMonth();
		case CREDIT_CARD_EXP_YEAR: return generateCreditCardNExpYear();
		default: {
			throw new RuntimeException(String.format("O valor '%s' não está disponível. Por favor, contate o suporte", RandomDataType.name()));
		}
		}
	}

	private String generateCreditCardExpMonth() {

		return String.valueOf((int)Math.ceil(Math.random()*12));
	}

	private String generateCreditCardNExpYear() {

		return String.valueOf(LocalDate.now().getYear()+(int)(5*Math.random()));
	}

	private String generateCreditCard() {
		
		return null;
	}

	private String generateCreditCardNumber() {
		return RandomStringUtils.randomNumeric(16);
	}

	private String selectCountry() {
		return Locale.getISOCountries()[Locale.getISOCountries().length*(int)Math.random()];
	}

	private String generateCity() {
		
		return "DEMO_CITY".concat(LocalDateTime.now().toString());
	}

	private String generateFullName() {
		
		return "DEMO_FULL_NAME".concat(LocalDateTime.now().toString());
	}

	private String generateRandomSurname() {
		
		return "DEMO_SURNAME".concat(LocalDateTime.now().toString());
	}

	private String generateRandomFirstName() {
		
		return "DEMO_FIRST_NAME".concat(LocalDateTime.now().toString());
	}

}
