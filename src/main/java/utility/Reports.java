package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReports() {
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter sparkReports = new ExtentSparkReporter("ExtentReports.html");
		reports.attachReporter(sparkReports);
		reports.setSystemInfo("CreatedBy", "Nihar");
		reports.setSystemInfo("Application", "SwagLab");
		return reports;
		
	}	
}
