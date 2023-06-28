package core.utils;

import java.time.Duration;
import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Waits {

	private FluentWait<WebDriver> wait;

	public Waits(WebDriver webdriver) {

		this.wait = new FluentWait<WebDriver>(webdriver);
	}

	// pense mesmo se vai precisar

	Object wait(WebElement element, Duration pollingTime, Duration timeout,
			Collection<Class<? extends Exception>> exceptions, ExpectedCondition<?>... expectedConditions) {

		return wait.pollingEvery(pollingTime).withTimeout(timeout).ignoreAll(exceptions)
				.until(ExpectedConditions.and(expectedConditions));
	}

	void elementIsVisible(WebElement element) {
		// deveria mesmo retornar elemento após a espera se a gente vai usar annotation?
		wait.pollingEvery(Duration.ofMillis(250)).withTimeout(Duration.ofMillis(1000))
				.until(ExpectedConditions.visibilityOf(element));
		// return false;
	}
//
//	boolean elementIsVisible() {
//
//		return false;
//	}
//
//	boolean elementIsCLicable() {
//
//		return false;
//	}
//
//	boolean elementIsInteractable() {
//
//		return false;
//	};

}
