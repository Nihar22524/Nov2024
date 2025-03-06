import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class ViewCartTest {
    WebDriver driver;
	@BeforeMethod
	public void LaunchApplication() {
		
		driver = LaunchBrowser.openBrowser("https://www.saucedemo.com/");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassWord("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	@Test
	public void verifyIfUserIsAbleToViewCart() {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.clickOnCart();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
	}
	
}
