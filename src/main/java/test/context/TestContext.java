package test.context;

import java.util.Collection;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import core.managers.DriverManager;
import core.managers.EvidenceManager;
import core.readers.ConfigFileReader;
import core.readers.data_readers.ExcelReader;
import core.utils.enums.ScenarioContextKeys;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class TestContext {

	private static DriverManager driverManager;
	private static ConfigFileReader configFileReader;
	private static ScenarioContext scenarioContext;
	private static ExcelReader excelReader;
	private static EvidenceManager evidenceManager;

	public static void setupApplication(Scenario scenario) {

		setScenarioContext(new ScenarioContext());
		setScenarioTagName(scenario.getSourceTagNames());
		setDriverManager(new DriverManager());
		setConfigFileReader(new ConfigFileReader());
		setExcelReader(new ExcelReader());
		setEvidenceManager(new EvidenceManager());

	}

	private static void setEvidenceManager(EvidenceManager evidenceManager) {
		TestContext.evidenceManager = evidenceManager;
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

	public static Row getRowByTaggedIdSheet() {
		// TODO: passar para actions!
		// Esse método já foi abstraído, não?
		return getExcelReader().getSheet(getScenarioContext()
				.getStringValue(ScenarioContextKeys.SCENARIO_ID))
				.getRow(1);
		
	}

	public static void cleanContext() {
		getScenarioContext().resetScenarioContext();
	}

	public static void createEvidence() {
		getEvidenceManager().createScreenshot();

	}

	private static EvidenceManager getEvidenceManager() {
		return TestContext.evidenceManager;
	}

	public static String getStatusString() {
		switch (getScenarioContext().getStatus()) {
		case PASSED:
			return "PASSOU";
		case FAILED:
		default:
			return "FALHOU";
		}
	}
	
	public static String getStatusFolder() {
		switch (getScenarioContext().getStatus()) {
		case PASSED:
			return "sucesso/";
		case FAILED:
		default:
			return "falha/";
		}
	}

	public static String getCurrentScenarioId() {
		return getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID);
	}

	public static void setStatus(Status status) {
		getScenarioContext().comuputeKey(ScenarioContextKeys.STATUS, status);
	}

}
