package test.hooks;

import io.cucumber.java.Before;
import test.context.TestContext;

public class Hooks {

	@Before
	public static void setupApplication() {
		TestContext.setupApplication();
	}
//
//	@After
//	public static void getEvidence(Scenario s) {
//		;
//	}
//
//	@AfterAll
//	public static void finishApplication() {
//		TestContext.finishApplication();
//	}
}
