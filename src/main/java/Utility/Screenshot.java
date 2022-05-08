package Utility;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
public static void takeScreenshot(WebDriver driver,String name) throws IOException {
	
	
		String date=Screenshot.date();
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination=new File("D:\\Automation\\kiteZeroda\\Screenshot\\"+name+"  "+date+" .jpg");
		
		FileHandler.copy(source, destination);
	}

public static String date() {
	DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");//format the time date and time as required
	LocalDateTime now=LocalDateTime.now();
	String date=dtf.format(now);
	return date;
}

}
