package core.utils.enums;

public enum ConfigKeys {

	WEBDRIVER_TYPE, HOMEPAGE_URL, DATASET_PATH, DATASET_FILENAME, DATASET_FORMAT;

	public String getValue() {
		return this.toString().toLowerCase().replaceAll("_", ".");
	}

}
