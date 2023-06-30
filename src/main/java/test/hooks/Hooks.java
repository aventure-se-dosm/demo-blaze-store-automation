package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import test.context.TestContext;

public class Hooks {

// Como devemos ter uma leitura por cenário
// Vamos testar com @After, ao invés...
//	@BeforeAll()
//	public static void setupApplication() {
//		TestContext.setupApplication();
//	}

	
	//é importante já termos o ID recuperável.
	@Before()
	public static void setupApplication(Scenario scenario) {
		TestContext.setupApplication(scenario);
	}

	@After()
	public static void closeWindow() {
		TestContext.closeBrowser();
	}

	@AfterAll()
	public static void finishApplication() {
		TestContext.finishApplication();
	}
}
