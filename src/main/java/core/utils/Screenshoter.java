package core.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.utils.enums.ValidFileFormats.ImageFormats;
import test.context.TestContext;

public class Screenshoter {
	
	public void takeScreenshot(String fullFilePath) {

		File shot = ((TakesScreenshot) TestContext.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shot, new File(fullFilePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenshot(String destination, String shotFileName, String defaultExtension) {
		takeScreenshot(destination + shotFileName + defaultExtension);
	}

	public void takeScreenshot(String destination, String statusFolder, String shotFileName, ImageFormats defaultExtension) {
		takeScreenshot(destination + statusFolder + shotFileName + "." + defaultExtension.name());
	}

}
