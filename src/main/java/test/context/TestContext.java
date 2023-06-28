package test.context;

import org.openqa.selenium.WebDriver;

import core.managers.DriverManager;
import core.readers.ConfigFileReader;

public class TestContext {

	private static DriverManager driverManager;
	private static ConfigFileReader configFileReader;

	public static ConfigFileReader getConfigReader() {
		if (configFileReader == null) {
			configFileReader = new ConfigFileReader();
			// driverManager = new DriverManager();
		}
		return configFileReader;
	}

	public static DriverManager getDriverManager() {
		return driverManager;
	}

	public static WebDriver getDriver() {
		if (getDriverManager() == null) {
			setDriverManager(new DriverManager());
		}
		return getDriverManager().getDriver();
	}

	private static void setDriverManager(DriverManager driverManager) {
		TestContext.driverManager = driverManager;
	}

	public static void finishApplication() {
		getDriverManager().finishDriver();
	}

	public static void setupApplication() {
		driverManager = new DriverManager();
		configFileReader = new ConfigFileReader();
	}

	public static void closeBrowser() {
		driverManager.closeDriver();
	}

}
