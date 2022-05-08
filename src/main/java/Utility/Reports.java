package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports addReport() {
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("extentreport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Env", "UAT");
		report.setSystemInfo("TestingType", "regression");
		return report;
		
	}

}
