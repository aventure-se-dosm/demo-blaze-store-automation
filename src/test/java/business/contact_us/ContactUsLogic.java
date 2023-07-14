package business.contact_us;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class ContactUsLogic {

	private ContactUsPage contactUsPage;
	private ContactUsModel contactUsModel;
	private PageActions actions;

	public ContactUsLogic() {
		setupContactUsLogic();
	}

	public void setupContactUsLogic() {
		setPage();
		setModel();
		setActions(new PageActions());
	}

	private void setModel() {
		this.contactUsModel = new ContactUsModel(TestContext.getRowByTaggedIdSheet());
	}

	private void setPage() {
		this.contactUsPage = new ContactUsPage();
	}

	public ContactUsPage getContactUsPage() {
		return contactUsPage;
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	public void startNavigation() {
		setupContactUsLogic();
		getActions().getUrl(TestContext.getConfigReader().getHomePage());
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public void goToContactUs() {
		WebElement welem = getContactUsPage().getLinkContactUs();
		getActions().click(welem);
	}

	public PageActions getActions() {
		return this.actions;
	}

	public ContactUsModel getModel() {
		return this.contactUsModel;
	}

	public boolean isMessageSent() {
		try {
			String alertMessage = actions.getAlertText();
			return alertMessage.equals(getContactUsPage().getMessageSentSuccessifully());
		}
		catch (Exception e) {
			return false;
		}
		
	}

	public void fillTxtContactName() {
		getActions().write(getContactUsPage().getTxtContactName(), getModel().getContactUsername());
	}
	public void fillTxtContactEmail() {
		getActions().write(getContactUsPage().getTxtContactEmail(), getModel().getContactEmail());
	}
	public void fillMessage() {
		getActions().write(getContactUsPage().getTxtContactMessage(), getModel().getMessage());
	}
}
