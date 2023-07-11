package core.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import core.utils.Waits;
import test.context.TestContext;

public class PageActions {

	private JavascriptExecutor jsExecutor;
	private Waits wait;

	public PageActions() {

		setJavaScriptExecutor();
		setWait(new Waits());
	}

	public void click(WebElement element) {

		scrollToElement(element);
		if (getWait().elementIsClickable(element))
			;
		element.click();
	}

	public String getText(WebElement element) {
		if (getWait().elementIsVisible(element))
			return element.getText();
		throw new RuntimeException(String.format("O elemento '%s' não foi encontrado", element.toString()));
	}

	public void getUrl(String url) {
		TestContext.getDriver().get(url);
	}

	public Waits getWait() {
		return this.wait;
	}

	void scrollToElement(WebElement element) {
		
		jsExecutor.executeScript("scroll(arguments[0]);", element);
	}

	private void setJavaScriptExecutor() {
		jsExecutor = (JavascriptExecutor) TestContext.getDriver();
	}

	private void setWait(Waits wait) {
		this.wait = wait;
	}

	public void write(WebElement element, String keysToSend) {
		scrollToElement(element);
		getWait().elementIsVisible(element);
		element.sendKeys(keysToSend);
	}
	
	public void write(WebElement element, WebElement container, String keysToSend) {
		scrollToElement(element);
		getWait().elementIsVisible(container, element);
		element.sendKeys(keysToSend);
	}

	public boolean isEachWebElementPresent(WebElement... elements) {
		return getWait().elementIsVisible(elements);
	}

}
