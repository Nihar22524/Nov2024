package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCartPage {

	@FindBy (xpath="//div[@class='cart_item']") private List<WebElement> products; 
	@FindBy (xpath="//span[@data-test='Title']") private WebElement title; 
	@FindBy (xpath="//button[@id='continue-shopping']") private WebElement continueShopping; 
	@FindBy (xpath="//button[@id='checkout']") private WebElement checkout; 
	@FindBy (xpath="//div[@class='inventory_item_name']") private List<WebElement> productName; 
	@FindBy (xpath="//div[@class='inventory_item_price']") private List<WebElement> productPrice; 
	@FindBy (xpath ="//button[text()='Remove']") private List<WebElement> remove;
	@FindBy (xpath ="//div[@class='cart_item_label']") private List<WebElement> cartProducts;
	
	public SwagLabCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public int getNumberProductInCart() {
		return products.size();
	}
	public String getCartTitle() {
		return title.getText();
	}
	public void clickOnContinueShopping() {
		continueShopping.click();
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	public double getProductPrice(int index) {
		 String price =productPrice.get(index).getText().substring(0);
		return Double.parseDouble(price);
	}
	public void clickOnRemoveCart(int index) {
		 remove.get(index).click();
	}
	public int totalProductsInCart() {
		return cartProducts.size();
	}
	
	}
