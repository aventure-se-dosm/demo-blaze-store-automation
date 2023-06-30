package core.utils.enums;

public enum ConfigKeys {

	WEBDRIVER_TYPE, HOMEPAGE_URL,
	// DATASET_FORMAT,
	WORKBOOK_FORMAT;

	public String getValue() {
		return this.toString().toLowerCase().replaceAll("_", ".");
	}
}
