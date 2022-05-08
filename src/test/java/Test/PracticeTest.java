package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pojo.Browser;


@Listeners(ListnerTest.class)
public class PracticeTest {
	
	
//	@BeforeMethod
//	public void browserl() {
//		Browser.openbrowser("https://kite.zerodha.com/");
//	}
	
	@Test
	public void Test1() {
		System.out.println("Test pass1");
	}
	
	@Test
	public void Test2() {
		System.out.println("Test fail");
		AssertJUnit.assertTrue(false);
	}
	
	@Test(dependsOnMethods= {"Test2"})
	public void Test3() {
		System.out.println("Test3Fail");
	}

}
