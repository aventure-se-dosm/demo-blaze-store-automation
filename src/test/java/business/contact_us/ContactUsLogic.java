package business.contact_us;

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

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	public void startNavigation() {
		setupContactUsLogic();
		getActions().getUrl(TestContext.getConfigReader().getHomePage());
	}

	public ContactUsPage getPage() {

		return contactUsPage;
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public void goToContactUs() {

		WebElement welem = getPage().getLinkContactUs();

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

			return alertMessage.equals(getPage().getMessageSentSuccessifully());

		} catch (Exception e) {
			return false;
		}

	}

	public void fillTxtContactName() {

		getActions().write(getPage().getTxtContactName(), getModel().getContactUsername());
	}

	public void fillTxtContactEmail() {
		getActions().write(getPage().getTxtContactEmail(), getModel().getContactEmail());
	}

	public void fillMessage() {
		getActions().write(getPage().getTxtContactMessage(), getModel().getMessage());
	}

	public void sendMessage() {
		getActions().click(getPage().getBtnSendMessage());

	}
}
