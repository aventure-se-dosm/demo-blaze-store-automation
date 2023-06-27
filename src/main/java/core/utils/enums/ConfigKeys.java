package core.utils.enums;

public enum ConfigKeys {

	WEBDRIVER_TYPE("webdriver.type"), STARTING_URL("starting.url");
	
	private String propertyKey;

	ConfigKeys(String propertyKey){
		this.propertyKey = propertyKey;
	}
	
	public String getValue(){
		return this.propertyKey;
	}
}
