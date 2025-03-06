import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class AboutPageTest {
  WebDriver driver;
	@BeforeMethod
	public void LaunchApplication() {
		driver =LaunchBrowser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassWord("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	@Test
	public void verifyIfAboutPageIsAccesscible() throws InterruptedException {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnMenu();
		Thread.sleep(5000);
		swagLabHomePage.clickOnAbout();
		Assert.assertEquals(driver.getTitle(), "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
	}
	
}
