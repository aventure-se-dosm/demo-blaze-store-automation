package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.context.TestContext;

public class Hooks {

	@Before()
	public static void setupApplication(Scenario scenario) {
		TestContext.setupApplication(scenario);
	}

	@After()
	public static void closeWindow() {
		TestContext.cleanContext();
		TestContext.createEvidence();
		TestContext.closeBrowser();
	}

	@AfterAll()
	public static void finishApplication() {
		TestContext.finishApplication();
	}
}
