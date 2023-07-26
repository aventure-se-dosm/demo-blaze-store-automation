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

	private static ConfigFileReader configFileReader;
	private static DriverManager driverManager;
	private static EvidenceManager evidenceManager;
	private static ExcelReader excelReader;
	private static ScenarioContext scenarioContext;

	public static final int FIRST_DATA_ROW_INDEX = 1;
	public static final int HEADER_INDEX = 0;
	private static final String FILE_SEPARATOR = "/";

	public static void cleanContext() {
		getScenarioContext().resetScenarioContext();
	}

	public static void closeBrowser() {
		driverManager.closeDriver();
	}

	public static void createEvidence() {
		getEvidenceManager().createScreenshot();

	}

	public static void finishApplication() {

		getDriverManager().finishDriver();

	}

	public static ConfigFileReader getConfigReader() {
		if (configFileReader == null) {
			configFileReader = new ConfigFileReader();
		}
		return configFileReader;
	}

	public static String getCurrentScenarioId() {
		return getScenarioContext().getStringValue(ScenarioContextKeys.SCENARIO_ID);
	}

	public static WebDriver getDriver() {
		if (getDriverManager() == null) {
			setDriverManager(new DriverManager());
		}
		return getDriverManager().getDriver();
	}

	public static DriverManager getDriverManager() {
		return driverManager;
	}

	private static EvidenceManager getEvidenceManager() {
		return TestContext.evidenceManager;
	}

	static ExcelReader getExcelReader() {
		return TestContext.excelReader;
	}
	
	

	public static Row getRowByTaggedIdSheet() {

		Row row = getExcelReader().actions()
				.getRow(getScenarioContext()
						.getStringValue(ScenarioContextKeys.SCENARIO_ID), FIRST_DATA_ROW_INDEX);
		return row;

	}

	public static ScenarioContext getScenarioContext() {
		if (TestContext.scenarioContext == null)
			setScenarioContext(new ScenarioContext());
		return TestContext.scenarioContext;
	}

	public static String getStatusFolder() {
		switch (getScenarioContext().getStatus()) {
		case PASSED:
			return getConfigReader().getEvidenceSuccessPath();
		case FAILED:
		default:
			return getConfigReader().getEvidenceFailPath();
		}
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

	private static void setConfigFileReader(ConfigFileReader configFileReader) {
		TestContext.configFileReader = configFileReader;
	}

	private static void setDriverManager(DriverManager driverManager) {
		TestContext.driverManager = driverManager;
	}

	private static void setEvidenceManager(EvidenceManager evidenceManager) {
		TestContext.evidenceManager = evidenceManager;
	}

	private static void setExcelReader(ExcelReader excelReader) {
		TestContext.excelReader = excelReader;
	}

	private static void setScenarioContext(ScenarioContext scenarioContext) {
		TestContext.scenarioContext = scenarioContext;
	}

	private static void setScenarioTagName(Collection<String> sourceTagNames) {
		String tag = null;
		tag = sourceTagNames.stream().filter(t -> t.startsWith("@ID_")).map(t -> t.replace("@", "")).findFirst().get();
		getScenarioContext().comuputeKey(ScenarioContextKeys.SCENARIO_ID, tag);
	}

	public static void setStatus(Status status) {
		getScenarioContext().comuputeKey(ScenarioContextKeys.STATUS, status);
	}

	public static String makePath(String... directories) {
		return String.join(FILE_SEPARATOR, directories).replace("(" + FILE_SEPARATOR + "){1,}", FILE_SEPARATOR);
	}

	public static void setupApplication(Scenario scenario) {

		setScenarioContext(new ScenarioContext());
		setScenarioTagName(scenario.getSourceTagNames());
		setDriverManager(new DriverManager());
		setConfigFileReader(new ConfigFileReader());
		setExcelReader(new ExcelReader());
		setEvidenceManager(new EvidenceManager());

	}

}
