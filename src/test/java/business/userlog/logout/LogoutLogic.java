package business.userlog.logout;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import business.userlog.LoginOutLogic;
import business.userlog.logout.LogoutModel.LoginAttributes;
import core.actions.PageActions;
import test.context.TestContext;

public class LogoutLogic extends LoginOutLogic{


	public LogoutLogic() {
		setupLogoutLogic();
	}


	public void logout() {
		actions.click(getLogoutPage().getLogoutLink());
	}
}
