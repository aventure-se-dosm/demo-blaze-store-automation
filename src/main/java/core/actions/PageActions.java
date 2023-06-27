package core.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import test.context.TestContext;

public class PageActions {

	private JavascriptExecutor jsExecutor;

	void scrollToElement(WebElement element) {
		jsExecutor.executeScript("scroll(arguments[0];", element);
	}

	public void startBrowser(String url) {
		TestContext.getDriver().get(url);
	}

}
