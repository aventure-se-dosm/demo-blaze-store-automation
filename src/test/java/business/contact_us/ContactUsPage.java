package business.contact_us;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.context.TestContext;

public class ContactUsPage {

	ContactUsPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	@FindBy(xpath = "//div[@id='navbarExample']//a[.='Contact']")
	private WebElement linkContactUs;
	@FindBy(id = "recipient-name")
	private WebElement txtContactName;
	@FindBy(id = "recipient-email")
	private WebElement txtContactEmail;
	@FindBy(id = "message-text")
	private WebElement txtContactMessage;
	@FindBy(xpath = "//button[@onclick='send()']")
	private WebElement btnSendMessage;

	protected WebElement getLinkContactUs() {
		return linkContactUs;
	}

	protected WebElement getTxtContactName() {
		return txtContactName;
	}

	protected WebElement getTxtContactEmail() {
		return txtContactEmail;
	}

	protected WebElement getTxtContactMessage() {
		return txtContactMessage;
	}

	protected WebElement getBtnSendMessage() {
		return btnSendMessage;
	}
}
