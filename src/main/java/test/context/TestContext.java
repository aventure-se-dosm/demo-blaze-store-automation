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
			driverManager = new DriverManager();
		}
		return configFileReader;
	}

//	public static ConfigFileReader getExcelReader() {
////		if (excelReader == null) {
////			excelReader = new excelReader();
////		}
////		return excelReader;
//		return null;
//	}

	public static WebDriver getDriver() {
		if (driverManager == null)
			driverManager = new DriverManager();
		return driverManager.getDriver();
	}

	public static void finishApplication() {
		// TODO Auto-generated method stub

	}

	public static void setupApplication() {

	}

}
