import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class ProductSortTest {
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
	public void verifySortingProductWithAToZ() {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Name (Z to A)");
		String firstProduct =swagLabHomePage.getProductName(0);
		String lastProduct =swagLabHomePage.getProductName(5);
			swagLabHomePage.selectSortType("Name (A to Z)");
			Assert.assertEquals(swagLabHomePage.getProductName(0), lastProduct);
			Assert.assertEquals(swagLabHomePage.getProductName(5),  firstProduct);
	 	
}    	 
	@Test
	public void verifySortingOfProductWithZToA() {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		String firstProduct = swagLabHomePage.getProductName(0);
		String lastProduct = swagLabHomePage.getProductName(5);
		swagLabHomePage.selectSortType("Name (Z to A)");
		Assert.assertEquals(swagLabHomePage.getProductName(0), lastProduct);
		Assert.assertEquals(swagLabHomePage.getProductName(5), firstProduct);
	}
	@Test
	public void verifySortingWithLowToHigh() {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Price (low to high)");
		Assert.assertTrue(swagLabHomePage.getProductPrice(0)<=swagLabHomePage.getProductPrice(1));
		Assert.assertTrue(swagLabHomePage.getProductPrice(1)<=swagLabHomePage.getProductPrice(2));
		Assert.assertTrue(swagLabHomePage.getProductPrice(2)<=swagLabHomePage.getProductPrice(3));
		Assert.assertTrue(swagLabHomePage.getProductPrice(3)<=swagLabHomePage.getProductPrice(4));
		Assert.assertTrue(swagLabHomePage.getProductPrice(4)<=swagLabHomePage.getProductPrice(5));
	}
	@Test
	public void verifySortingWithHighToLow() {
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		swagLabHomePage.selectSortType("Price (high to low)");
		Assert.assertTrue(swagLabHomePage.getProductPrice(0)>=swagLabHomePage.getProductPrice(1));
		Assert.assertTrue(swagLabHomePage.getProductPrice(1)>=swagLabHomePage.getProductPrice(2));
		Assert.assertTrue(swagLabHomePage.getProductPrice(2)>=swagLabHomePage.getProductPrice(3));
		Assert.assertTrue(swagLabHomePage.getProductPrice(3)>=swagLabHomePage.getProductPrice(4));
		Assert.assertTrue(swagLabHomePage.getProductPrice(4)>=swagLabHomePage.getProductPrice(5));
	}
}
