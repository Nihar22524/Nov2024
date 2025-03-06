package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
public static void main(String [] args) throws IOException	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nihar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       driver.get("https://www.facebook.com");
		
	   File Source=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\nihar\\OneDrive\\Documents\\Screenshot\\facebook.jpg");
		
		FileHandler.copy(Source, destination);
}
}