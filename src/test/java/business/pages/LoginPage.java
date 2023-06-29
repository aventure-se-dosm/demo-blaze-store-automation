package business.pages;

import org.openqa.selenium.support.PageFactory;

import business.steps.Page;
import test.context.TestContext;

public class LoginPage extends Page {

	public LoginPage() {
		super();
		PageFactory.initElements(TestContext.getDriver(), this);

	}

	public void startBrowser() {
		driver.get(TestContext.getConfigReader().getStartingUrl());
	}

}
