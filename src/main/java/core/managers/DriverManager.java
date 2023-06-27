package core.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.utils.enums.WebDriverTypes;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.context.TestContext;;

public class DriverManager {

	private WebDriver webdriver;

	public static void setupDrivers() {
		WebDriverManager.chromedriver().setup();
	}

	public WebDriver getDriver() {
		if (webdriver == null) {
			setupDrivers();
			setDriver();
		}

		return webdriver;
	}

	private void setDriver() {
		setDriver(WebDriverTypes.valueOf(TestContext.getConfigReader().getDefaultDriver()));
	}

	private void setDriver(WebDriverTypes driverType) {
		switch (driverType) {
		case EDGE: {
			webdriver = new EdgeDriver();
			break;
		}
		case FIREFOX: {
			webdriver = new FirefoxDriver();
			break;
		}
		case CHROME:
		default: {
			webdriver = new ChromeDriver(new ChromeOptions().addArguments("--allow-remote-origins=*"));
			break;
		}
		}

	}

}
