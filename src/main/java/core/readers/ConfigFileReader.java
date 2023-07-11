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

	public String getDataFileName() {
		return getproperty(ConfigKeys.DATASET_FILENAME);
	}

	public String getDataSetFormat() {
		return getproperty(ConfigKeys.DATASET_FORMAT);
	}

	public String getDataSetFullPath() {
		return (getDataSetPath() + "/" + getDataFileName() + "." + getDataSetFormat()).replaceAll("[\\.]+", ".")
				.replaceAll("[\\/]+", "/").replaceAll("[\\\\]+", "\\");

	}

	public String getDataSetPath() {
		return getproperty(ConfigKeys.DATASET_PATH);
	}

	public String getDefaultDriver() {
		return getproperty(ConfigKeys.WEBDRIVER_TYPE).toUpperCase();

	}

	public String getDefaultEvidenceFormat() {
		return getproperty(ConfigKeys.EVIDENCE_FORMAT);
	}

	public String getEvidenceSuccessPath() {
		return getproperty(ConfigKeys.EVIDENCE_PATH_SUCCESS);
	}

	public String getEvidenceFailPath() {
		return getproperty(ConfigKeys.EVIDENCE_PATH_FAIL);
	}

	public String getDefaultEvidencePath() {
		return getproperty(ConfigKeys.EVIDENCE_PATH);
	}

	public String getHomePage() {
		return getproperty(ConfigKeys.HOMEPAGE_URL);
	}

	private Properties getProperties() {
		return properties;
	}

	private String getproperty(ConfigKeys configKey) {
		return getProperties().getProperty(configKey.getValue().toLowerCase());
	}

}
