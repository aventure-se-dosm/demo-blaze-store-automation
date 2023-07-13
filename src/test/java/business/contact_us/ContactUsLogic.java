package business.contact_us;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class ContactUsLogic {

	private ContactUsPage contactUsPage;
	private PageActions actions;

	public ContactUsLogic() {
		setupContactUsLogic();
	}

	public void setupContactUsLogic() {
		setPage();
		setActions(new PageActions());

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

	
	public boolean isMessageSent() {
		//TODO: implementation
		return false;
	}
}
