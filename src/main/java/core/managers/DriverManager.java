package core.managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.utils.enums.WebDriverTypes;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.context.TestContext;;

public class DriverManager {
	private WebDriver webdriver;

	public DriverManager() {
		getDriver();
	}

	public static void setupDrivers() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
	}

	private boolean isWebDriverExtant() {
		return webdriver != null;
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
			webdriver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
			break;
		}

		case FIREFOX: {
			webdriver = new FirefoxDriver();
			break;
		}
		case CHROME:
		default: {
			webdriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
			break;
		}
		}

		webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		webdriver.manage().window().maximize();
	}

	private void simpleCloseDriver() {
		webdriver.close();
	}

	private void killDriver() {
		if (isWebDriverExtant()) {
			webdriver.quit();
		}
		setDriverNull();

	}

	private void setDriverNull() {
		webdriver = null;
	}

	public void closeDriver() {
		if (isWebDriverExtant()) {
			simpleCloseDriver();
		}
		setDriverNull();
	}

	public void finishDriver() {
		if (isWebDriverExtant()) {
			killDriver();
		}
		setDriverNull();
	}
}
