package test.context;

import java.util.Collection;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import core.managers.DriverManager;
import core.readers.ConfigFileReader;
import core.readers.data_readers.ExcelReader;
import core.utils.enums.ScenarioContextKeys;
import io.cucumber.java.Scenario;

public class TestContext {

	private static DriverManager driverManager;
	private static ConfigFileReader configFileReader;
	private static ScenarioContext scenarioContext;
	private static ExcelReader excelReader;

	public static void setupApplication(Scenario scenario) {

		setScenarioContext(new ScenarioContext());
		setScenarioTagName(scenario.getSourceTagNames());
		setDriverManager(new DriverManager());
		setConfigFileReader(new ConfigFileReader());
		setExcelReader(new ExcelReader());

	}

	private static void setScenarioTagName(Collection<String> sourceTagNames) {
		String tag = null;
		// TODO: it would throw NoSuchElementException
		tag = sourceTagNames.stream().filter(t -> t.startsWith("@ID_")).map(t -> t.replace("@", "")).findFirst().get();
		getScenarioContext().comuputeKey(ScenarioContextKeys.SCENARIO_ID, tag);
	}

	public static ConfigFileReader getConfigReader() {
		if (configFileReader == null) {
			configFileReader = new ConfigFileReader();
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

	private static void setConfigFileReader(ConfigFileReader configFileReader) {
		TestContext.configFileReader = configFileReader;
	}

	private static void setExcelReader(ExcelReader excelReader) {
		TestContext.excelReader = excelReader;
	}

	private static void setScenarioContext(ScenarioContext scenarioContext) {
		TestContext.scenarioContext = scenarioContext;
	}

	private static void setDriverManager(DriverManager driverManager) {
		TestContext.driverManager = driverManager;
	}

	public static ScenarioContext getScenarioContext() {
		if (TestContext.scenarioContext == null)
			setScenarioContext(new ScenarioContext());

		return TestContext.scenarioContext;
	}

	static ExcelReader getExcelReader() {
		return TestContext.excelReader;
	}

	public static void closeBrowser() {
		driverManager.closeDriver();
	}

	public static void finishApplication() {
		getDriverManager().finishDriver();
	}

	/*
	 * Retorna a primeira linha da sheet correspondente à tag definida;
	 */
	public static Row getRowByTaggedIdSheet() {
		return getExcelReader().getRow();
	}

	/*
	 * Retorna a linha da sheet correspondente à tag definida.
	 * 
	 */

}
