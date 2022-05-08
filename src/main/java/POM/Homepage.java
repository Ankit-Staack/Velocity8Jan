package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	
	@FindBy(xpath="//span[text()='TATAMOTORS']")private WebElement tatamotors;
	@FindBy(xpath="//button[@class='button-blue buy']") private WebElement buy;
	@FindBy(xpath="//div[@class=\"vddl-list list-flat\"]//span//span//span[@class=\"nice-name\"]") private List<WebElement> stocks;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selecttatamotors(WebDriver driver) {
		
		WebDriverWait wait=new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(tatamotors));
		Actions action=new Actions(driver);
		action.moveToElement(tatamotors);
		action.perform();
	}
	
	public void listofstocks(WebDriver driver,String stockName) {    // used string stocksName instid of int i to select stocks using stk name used String stockName
		WebDriverWait wait=new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(tatamotors));
		
		for (int a=0;a<stocks.size();a++) {  // this method are used for select the stocks using name in testHomePageActions class by passing string name
			
			System.out.println(stocks.size());
			
			String text=stocks.get(a).getText();
			
			if(text.equalsIgnoreCase(stockName)) {
				
				Actions action=new Actions(driver);
				
				action.moveToElement(stocks.get(a));  // if we used stk name instid of index then pass get(a) in get(i)
				action.perform();
			}
		}
	}
		
	
	public void clicktobuy() {
		buy.click();
	}
}
