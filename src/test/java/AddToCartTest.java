import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.LaunchBrowser;
import pom.SwagLabCartPage;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;

public class AddToCartTest {
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
    public void verifyOnClickingAddToCartRemoveOptionIsDisplayed() {
    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
    	swagLabHomePage.clickOnaddToCart(0);
    	Assert.assertTrue(swagLabHomePage.isRemoveButtonDisplayed(0));
    }
    @Test
    public void verifyUserIsAbleProductToCart() {
    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
    	swagLabHomePage.clickOnaddToCart(0);
    	swagLabHomePage.clickOnCart();
    	SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
    	Assert.assertEquals(swagLabCartPage.getNumberProductInCart(), 1);
    }
    @Test
    public void verifyIfUserIsAbletoRemoveAddedProductToCartFromHomePage() {
    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
    	swagLabHomePage.clickOnaddToCart(0);
    	swagLabHomePage.clickOnCart();
    	SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
    	Assert.assertEquals(swagLabCartPage.getNumberProductInCart(), 1);
    	swagLabCartPage.clickOnContinueShopping();
    	swagLabHomePage.removeProductFromCart(0);
    	swagLabHomePage.clickOnCart();
    	Assert.assertEquals(swagLabCartPage.getNumberProductInCart(), 0);
    }
    @Test
    public void verifyUserIsAbleToRemoveProductFromCart() {
    	SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
    	swagLabHomePage.clickOnaddToCart(0);
    	swagLabHomePage.clickOnaddToCart(1);	
    	swagLabHomePage.clickOnaddToCart(2);
    	swagLabHomePage.clickOnCart();
    	
    	SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
    	swagLabCartPage.clickOnRemoveCart(0);
    	Assert.assertEquals(swagLabCartPage.totalProductsInCart(), 2);
      }
      @Test
      public void verifyIfCorrectProductIsAddedToCart() {
    	  SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
    	  swagLabHomePage.clickOnaddToCart(0);
    	  String productNameOnHomePage = swagLabHomePage.getProductName(1);
    	  double priceOnHomePage = swagLabHomePage.getProductPrice(1);
    	  swagLabHomePage.clickOnCart();
    	  SwagLabCartPage swagLabCartPage = new SwagLabCartPage(driver);
    	  SoftAssert softAssert = new SoftAssert();
    	  softAssert.assertEquals(swagLabCartPage.getProductName(0), productNameOnHomePage);
    	  softAssert.assertEquals(swagLabCartPage.getProductPrice(0), priceOnHomePage);
    	  softAssert.assertAll();
    	  
      }
    
    
}
