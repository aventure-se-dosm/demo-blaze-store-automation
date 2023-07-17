package business.about_us;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import core.actions.PageActions;
import test.context.TestContext;

public class AboutUsLogic {

	protected AboutUsPage page;
	protected PageActions actions;
	// protected AboutUsModel model;

	public AboutUsLogic() {
		setupAboutUsLogic();
	}

	public void setupAboutUsLogic() {
		setPage();
		setActions(new PageActions());

	}

	private void setPage() {
		this.page = new AboutUsPage();
	}

	public AboutUsPage getAboutUsPage() {
		return (AboutUsPage) this.page;
	}

	private void setActions(PageActions actions) {
		this.actions = actions;
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
	getActions().click(getAboutUsPage().getLinkAboutUs());
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
