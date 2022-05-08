package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.zerodaLogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Reports;
import Utility.Screenshot;

@Listeners(ListnerTest.class)
public class LoginTest extends BaseTest{
	
	

	ExtentReports report;
	ExtentTest test;
	@BeforeClass
	public void setreport() {
		report=Reports.addReport();
	}
	
	
	@BeforeMethod
	public void launchbrowser(){
		driver=Browser.openbrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void Loginwithvalidcredentials() throws InterruptedException, EncryptedDocumentException, IOException {
		test=report.createTest("Loginwithvalidcredentials");
		zerodaLogin Zerodalogin=new zerodaLogin(driver);
		String user=Excel.getTextdata("CredentiaLs", 0, 1);
		Zerodalogin.enterusername(user);
		String pass=Excel.getTextdata("CredentiaLs", 1, 1);
		Zerodalogin.enterpass(pass);
		Zerodalogin.loginbutton();
		String pin=Excel.getTextdata("CredentiaLs", 2, 1);
		Zerodalogin.enterpin(pin, driver);
		Zerodalogin.submitbutton();
		
		
		AssertJUnit.assertTrue(false);
	}
	
	@Test
	public void signup() {
		test=report.createTest("signup");
		zerodaLogin Zeroda=new zerodaLogin(driver);
		Zeroda.newaccount();
		
	}
	
	@AfterMethod
	public void caterResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
		}
		
		else {
			test.log(Status.SKIP, result.getName());
		}
			
	}	
	@AfterClass
	public void flushResult() 
	{
		report.flush();
	}

}
