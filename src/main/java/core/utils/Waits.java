package core.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import test.context.TestContext;

public class Waits {

	private FluentWait<WebDriver> fluentWait;

	public Waits() {
		this(TestContext.getDriver());

	}

	public Waits(WebDriver webdriver) {
		this.fluentWait = new FluentWait<WebDriver>(webdriver);
	}

	public boolean elementIsClickable(WebElement element) {
		return fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(element),
						ExpectedConditions.elementToBeClickable(element)));
	}

	public boolean elementIsVisible(WebElement... elements) {
		return (fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(elements)) != null);

	}

	public void jsExecutesSuccessifully(String jsScript) {
		fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.javaScriptThrowsNoExceptions(jsScript));
	}

	public void jsFinishedSuccessifully() {
		jsExecutesSuccessifully("return jQuery.active==0");
	}

	public Alert alertIsPresent() {
		return fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.alertIsPresent());
	}

}
