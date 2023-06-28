package business.steps;

import org.openqa.selenium.WebDriver;

import core.actions.PageActions;
import core.utils.Waits;
import test.context.TestContext;

public abstract class Page {

	protected PageActions actions;
	protected Waits waits;
	protected WebDriver driver;

	public Page() {
		this.actions = new PageActions();
		this.driver = TestContext.getDriver();
	}

	public void closeBrowser() {
		TestContext.getDriverManager();
	}
}
