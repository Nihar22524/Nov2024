import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class SwagLabLogoutTest {
    WebDriver driver;
	@BeforeMethod
	public void LaunchApplication() {
		driver = LaunchBrowser.openBrowser("https://www.saucedemo.com/");
	}
	@Test
	public void verifyIfUserIsAbleToLogout() throws InterruptedException {
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassWord("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		Thread.sleep(5000);
		swagLabHomePage.clickOnLogout();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
	}
}
