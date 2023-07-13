package test.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class RandomDataModelCreator {

	// leave away abstracts reference naming if you actually won't make
	// real another kind of data sources implemented - Such as BD by Factory
	// pattern.

	Workbook randomDataSource;
	Sheet entityFields;

	RandomDataModelCreator() {
	}

	public String generateRandomPrintableString(int length) {
		return RandomStringUtils.randomAscii(length);
	}

	public String generateAlphanumericString(int minLength, int maxLenght) {
		return RandomStringUtils.randomAlphanumeric(minLength, (maxLenght + 1));
	}

	// public abstract Object

}
