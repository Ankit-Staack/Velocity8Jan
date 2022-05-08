package POM;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;

public class zerodaLogin {
	
	@FindBy(xpath="//input[@id='userid']")private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement pass;
	@FindBy(xpath="//button[@class='button-orange wide']")private WebElement login;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgotpass;
	@FindBy(xpath="//a[@class='text-light']")WebElement signup;
	@FindBy(xpath="//input[@id='pin']")private WebElement Pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	
	
	public zerodaLogin(WebDriver driver) {
		PageFactory.initElements(driver,this);	
		
	}
	public void enterusername(String user) {
		username.sendKeys(user);
	}
	
	public void enterpass(String pass1) {
		pass.sendKeys(pass1);
	}
	
	public void loginbutton() {
		login.click();
	}
	
	public void forgotpassword() {
		forgotpass.click();
	}
	
	public void newaccount() {
		signup.click();
	}
	
	public void enterpin(String value,WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOf(Pin));
		
		Pin.sendKeys(value);
	}

	public void submitbutton() {
		submit.click();
	}
}
