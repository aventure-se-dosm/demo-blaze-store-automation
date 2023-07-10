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

	
	private String PathFilter (String pathString)
	{
		return 	pathString.replaceAll("[\\/]+", "/").replaceAll("[\\\\]+", "\\");
	}
	public String getDefaultDriver() {
		return getproperty(ConfigKeys.WEBDRIVER_TYPE).toUpperCase();
	}

	private String getproperty(ConfigKeys configKey) {
		return getProperties().getProperty(configKey.getValue().toLowerCase());
	}

	public String getHomePage() {
		// TODO Auto-generated method stub
		return getproperty(ConfigKeys.HOMEPAGE_URL);
	}

	public String getDataSetPath() {
		return getproperty(ConfigKeys.DATASET_PATH);
	}

	public String getDataFileName() {
		return getproperty(ConfigKeys.DATASET_FILENAME);
	}

	public String getDataSetFormat() {
		// TODO Auto-generated method stub
		return getproperty(ConfigKeys.DATASET_FORMAT);
	}

	public String getDataSetFullPath() {
		String s = (getDataSetPath() + "/" + getDataFileName() + "." + getDataSetFormat()).replaceAll("[\\.]+", ".")
				.replaceAll("[\\/]+", "/").replaceAll("[\\\\]+", "\\");
		return s;
	}

	public String getDefaultEvidenceFormat() {
		return getproperty(ConfigKeys.EVIDENCE_FORMAT);
	}

	public String getDefaultEvidencePath() {
		return getproperty(ConfigKeys.EVIDENCE_PATH);
	}
}
