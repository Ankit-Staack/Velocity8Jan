package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Newuser {
	
	@FindBy(xpath="//a[@class='text-light']")private WebElement UserAcc;
	@FindBy(xpath="/html/body/nav/div/div/div[1]/a/img")private WebElement logo;
	@FindBy(xpath="//input[@id='user_mobile']")private WebElement MobileNumber;
	@FindBy(xpath="//button[@id='open_account_proceed_form']") private WebElement clickoncontinue;
	
	public Newuser(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void AccOpen() {
		UserAcc.click();
	}
	
	public String getPagetitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public boolean logodispalyed() {
		return logo.isDisplayed();
	}
	
	public void enterMobile(String number) {
		MobileNumber.sendKeys(number);
	}
	
	public void continuenext() {
		clickoncontinue.click();
	}

}
