package core.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import core.utils.Waits;
import test.context.TestContext;

public class PageActions {

	private JavascriptExecutor jsExecutor;
	private Waits wait;

	public PageActions() {
		setWait(wait);
	}

	private void setWait(Waits wait) {
		this.wait = wait;
	}

	void scrollToElement(WebElement element) {
		jsExecutor.executeScript("scroll(arguments[0];", element);
	}

	public void getUrl(String url) {
		TestContext.getDriver().get(url);
	}

	public void click(WebElement element) {
		// TODO: wait para elementoclicável
		scrollToElement(element);
		element.click();
	}

	public void write(WebElement element, String keysToSend) {
		// TODO: wait para visibilidade de elemento
		scrollToElement(element);
		element.sendKeys(keysToSend);
	}

	public void submitForm(WebElement formElement) {
		// TODO: wait para envio de form --> mesmo que clicável?
		formElement.submit();
	}
	
	public String getCurrentUrl() {
		return TestContext.getDriver().getCurrentUrl();
	}

}
