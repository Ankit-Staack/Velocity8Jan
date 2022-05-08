package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.Newuser;
import Pojo.Browser;


public class SignupAcc {
	
	WebDriver driver;
	
	@BeforeMethod
	public void OpenBrowser() {
	 driver=Browser.openbrowser("https://kite.zerodha.com/");
	}
	
	
	@Test
	public void NewPage() {
		Newuser user=new Newuser(driver);
		user.AccOpen();
	   ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(list.get(1));
	    
		String actualtitle=user.getPagetitle(driver);
		String expectedtitle="Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
		SoftAssert softassert=new SoftAssert();
		AssertJUnit.assertEquals(actualtitle, expectedtitle);   // hard assert will stop the execution at this point
		
//		softassert.assertFalse(user.logodispalyed());
		
		AssertJUnit.assertTrue(user.logodispalyed());
		
		user.enterMobile("8329580034");
		softassert.assertAll();   // show all the capture failure
		
		user.continuenext();
		
	    
		
		
	}
	

}
