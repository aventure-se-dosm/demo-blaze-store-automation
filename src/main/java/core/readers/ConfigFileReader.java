package core.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import core.utils.enums.ConfigKeys;

public class ConfigFileReader {
	private static String configFilePath = "./src/config/config.properties";
	private Properties properties;

	public ConfigFileReader() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(configFilePath)));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (IOException excp) {

		}
	}

	private Properties getProperties() {
		return properties;
	}

	public String getDefaultDriver() {
		return getproperty(ConfigKeys.WEBDRIVER_TYPE);
	}

	private String getproperty(ConfigKeys configKey) {
		
		return getProperties().getProperty(configKey.getValue().toLowerCase()).toUpperCase();
	}

	public String getStartingUrl() {
		// TODO Auto-generated method stub
		return getproperty(ConfigKeys.STARTING_URL);
	}
}
