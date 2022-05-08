package Test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Homepage;
import POM.zerodaLogin;
import Pojo.Browser;
import Utility.Excel;


public class HomepageActions  {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void launchbrowserforhomepage() throws EncryptedDocumentException, IOException {
		driver=Browser.openbrowser("https://kite.zerodha.com/");
	}
		
		@Test
		public void withcredentials() throws EncryptedDocumentException, IOException {
		zerodaLogin Zerodalogin=new zerodaLogin(driver);
		String user=Excel.getTextdata("CredentiaLs", 0, 1);
		Zerodalogin.enterusername(user);
		String pass=Excel.getTextdata("CredentiaLs", 1, 1);
		Zerodalogin.enterpass(pass);
		Zerodalogin.loginbutton();
		String pin=Excel.getTextdata("CredentiaLs", 2, 1);
		Zerodalogin.enterpin(pin, driver);
		Zerodalogin.submitbutton();
		
		
	}
	
	@Test
	public void home() {
		Homepage homepage=new Homepage(driver);
		homepage.listofstocks(driver, "ADANIGREEN"); // if we want to select the stk using stk name then pass name in index(12)to stk in this method
		
		homepage.clicktobuy();
	}

}
