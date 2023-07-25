package core.utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.context.TestContext;

public class Waits {

	private FluentWait<WebDriver> fluentWait;

	public Waits() {
		this(TestContext.getDriver());

	}

	public void untilJqueryIsDone() {
		untilJqueryIsDone(TestContext.getDriver(), 5L);
	}

	public void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
		until(driver, (d) -> {
			Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone)
				System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
		});
	}

	public void untilPageLoadComplete() {
		untilPageLoadComplete(TestContext.getDriver(), 10L);
	}

	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds) {
		until(driver, (d) -> {
			Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("complete");
			if (!isPageLoaded)
				System.out.println("Document is loading");
			return isPageLoaded;
		});
	}

	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
		until(driver, waitCondition, TestContext.getConfigReader().getImplicitlyWait());
	}

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Duration timeoutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(Duration.ofSeconds(10));
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		return (fluentWait.pollingEvery(Duration.ofMillis(100)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfAllElements(elements)) != null);

	}

	public boolean elementIsNotVisible(WebElement element) {
		return fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.stalenessOf(element));

	}


	public void jsExecutesSuccessifully(String jsScript) {
		fluentWait.pollingEvery(Duration.ofMillis(500)).withTimeout(Duration.ofSeconds(10))
				.until(ExpectedConditions.javaScriptThrowsNoExceptions(jsScript));
	}

	public void jsFinishedSuccessifully() {
		untilJqueryIsDone();
	}

	public Alert alertIsPresent() {
		return fluentWait.pollingEvery(Duration.ofMillis(1000)).withTimeout(Duration.ofSeconds(5))
				.until(ExpectedConditions.alertIsPresent());
	}

}
