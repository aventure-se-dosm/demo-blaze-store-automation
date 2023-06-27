package business.steps;

import core.actions.PageActions;
import core.utils.Waits;
import test.context.TestContext;

public abstract class Page {

	protected PageActions actions;
	protected Waits waits;

	protected Page() {
		this.actions = new PageActions();
	}

	public void startBrowser() {
		TestContext.getDriver().get(TestContext.getConfigReader().getStartingUrl());
	}

	public void closeBrowser() {
		TestContext.getDriver().close();
	}
}
