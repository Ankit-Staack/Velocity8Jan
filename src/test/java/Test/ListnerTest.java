package Test;





import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.Screenshot;


public class ListnerTest extends BaseTest implements ITestListener {
	

	public void onTestStart(ITestResult result) {
		System.out.println("started"+result.getName());
	}
	
	public void onTestSuccess(ITestResult result){
		System.out.println("My test sucessfully pass"+ result.getName());
			
	}
	
	public void onTestFailure(ITestResult result) {
//		System.out.println("Test Fail"+result.getName());
		try {
			Screenshot.takeScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void OnTestSkipped(ITestResult result) {
		System.out.println("my Test skip"+result.getName());
	}

}
