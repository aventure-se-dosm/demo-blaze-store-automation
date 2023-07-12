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
		return fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element)) != null;
	}

	public boolean elementIsVisible(WebElement... elements) {
		return (fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(elements)) != null);

	}

	public void jsIsFinished() {
		fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.jsReturnsValue("0"));
	}

	public Alert alertIsPresent() {
		return fluentWait.pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.alertIsPresent());
	}

}
