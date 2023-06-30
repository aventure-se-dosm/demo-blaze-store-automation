package core.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {

	private FluentWait<WebDriver> wait;

	public Waits(WebDriver webdriver) {
		this.wait = new FluentWait<WebDriver>(webdriver);
	}

	/*
	 *
	 * Possível implementação caso as Wait abaixo possam ser abstraídas
	 * 
	 * 
	 * // public Object wait(WebElement element, Duration pollingTime, Duration
	 * timeout, // Collection<Class<? extends Exception>> exceptions,
	 * ExpectedCondition<?>... expectedConditions) { // // return
	 * wait.pollingEvery(pollingTime).withTimeout(timeout).ignoreAll(exceptions) //
	 * .until(ExpectedConditions.and(expectedConditions)); // }
	 */

	public WebElement elementIsVisible(WebElement element) {
		return wait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMillis(1000))
				.until(ExpectedConditions.visibilityOf(element));
	}

	public List<WebElement> nestedElementIsVisible(WebElement element, By childLocator) {
		return wait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMillis(1000))
				.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
	}

	public WebElement elementIsClickable(WebElement element) {
		return wait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMillis(1000))
				.until(ExpectedConditions.visibilityOf(element));
	}

}
