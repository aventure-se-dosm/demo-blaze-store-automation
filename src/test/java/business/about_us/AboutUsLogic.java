package business.about_us;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class AboutUsLogic {

	private AboutUsPage aboutUsPage;
	private PageActions actions;

	public AboutUsLogic() {
		setupAboutUsLogic();
	}

	public void setupAboutUsLogic() {
		setPage();
		setActions(new PageActions());

	}

	private void setPage() {
		this.aboutUsPage = new AboutUsPage();
	}

	public AboutUsPage getAboutUsPage() {
		return aboutUsPage;
	}

	private void setActions(PageActions pageActions) {
		this.actions = pageActions;
	}

	public void startNavigation() {
		setupAboutUsLogic();
		getActions().getUrl(TestContext.getConfigReader().getHomePage());
	}

	public String getUrlDaPaginaAtual() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return TestContext.getDriver();
	}

	public void goToAboutUs() {
		WebElement welem = getAboutUsPage().getLinkAboutUs();

		getActions().click(welem);
	}

	public PageActions getActions() {
		return this.actions;
	}

	public void playVideo() {
		getActions().click(getAboutUsPage().getExampleVideo());
	}
	
	public boolean isVideoElementVisible() {
		return getActions().getWait().elementIsVisible(getAboutUsPage().getExampleVideo());
	}

}
