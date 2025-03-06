import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.SwagLabHomePage;
import pojo.LaunchBrowser;
import pom.SwagLabLoginPage;

public class SwagLabLoginTest {

	WebDriver driver;
	@BeforeMethod
	public void LaunchApplication() {
	driver= LaunchBrowser.openBrowser("https://www.saucedemo.com/");
	}
	@Test
	public void verifySwagLabLogin() {
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassWord("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}
	@Test
	public void verifyAddToCart() {	
			SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
			SwagLabHomePage  swagLabHomePage  = new SwagLabHomePage(driver);
			swagLabLoginPage.enterUserName("standard_user");
			swagLabLoginPage.enterPassWord("secret_sauce");
			swagLabLoginPage.clickOnLogin();
			swagLabHomePage.clickOnaddToCart(0);
	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
		
	}
}