package business.about_us;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class AboutUsPage {
	AboutUsPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	@FindBy(xpath = "//a[@data-target='#videoModal']")
	private WebElement linkAboutUs;
	@FindBy(xpath = "//video[@id='example-video_html5_api']/..")
	private WebElement exampleVideo;

	public WebElement getLinkAboutUs() {
		return linkAboutUs;
	}

	public WebElement getExampleVideo() {
		return exampleVideo;
	}

}
