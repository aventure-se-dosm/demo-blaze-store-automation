package core.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

	public Boolean elementIsClickable(WebElement element) {
		return fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
						ExpectedConditions.elementToBeClickable(element)));
	}

	public WebElement elementIsVisible(WebElement element) {
		return fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> nestedElementIsVisible(WebElement element, By childLocator) {
		return fluentWait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMillis(3000))
				.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
	}

}
