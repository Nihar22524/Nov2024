package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver openBrowser (String url) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       driver.get(url);
    	return driver;
	
	}
	
}
