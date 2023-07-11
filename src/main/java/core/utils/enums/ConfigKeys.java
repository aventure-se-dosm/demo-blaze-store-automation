package core.utils.enums;

public enum ConfigKeys {

	DATASET_FILENAME, DATASET_FORMAT, 
	
	DATASET_PATH, EVIDENCE_FORMAT, EVIDENCE_PATH, 
	
	HOMEPAGE_URL, WEBDRIVER_TYPE, EVIDENCE_PATH_SUCCESS, EVIDENCE_PATH_FAIL;

	public String getValue() {
		return this.toString().toLowerCase().replaceAll("_", ".");
	}

}
