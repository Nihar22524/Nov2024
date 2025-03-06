package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {

	@FindBy(xpath ="//input[@type='text']") private WebElement userName;
	@FindBy(xpath ="//input[@type='password']") private WebElement passWord;
	@FindBy(xpath ="//input[@type='submit']") private WebElement Login;
	
	public SwagLabLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterUserName(String user) {
		userName.sendKeys(user);
	}
	public void enterPassWord(String pass) {
		passWord.sendKeys(pass);
	}
	public void clickOnLogin() {
		Login.click();
	}
	
}
