package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import test.context.TestContext;

public class Hooks {

	@BeforeAll()
	public static void setupApplication() {
		TestContext.setupApplication();
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
