package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import pojo.LaunchBrowser;

public class Parameterization {
    public static String main(String [] args) throws EncryptedDocumentException, IOException {
    	FileInputStream file = new FileInputStream("C:\\\\Users\\\\nihar\\\\OneDrive\\\\Documents\\\\Copy of Book1_-_Copy(1).xlsx");
    String value = 	WorkbookFactory.create(file).getSheet("Cread").getRow(3).getCell(0).getStringCellValue();
    	
    	return value;
    }
}
