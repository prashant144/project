package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

public class LoginTest extends TestBase {
	
	
	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.debug("LoginTest Started !!!!");
		driver.findElement(By.cssSelector(OR.getProperty("BankManagerLoginBtn"))).click();
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("AddCustBtn"))), "Login Not sucessfull");
		
		
		
		
		
		log.debug("LoginTest Sucessfully Executed !!!!");
		Reporter.log("LoginTest Sucessfully Executed !!!!");
		//Reporter.log("<a href=\"C:\\Users\\Paresh\\Desktop\\paresh123.jpg\">ScreenShot</a>");
		Reporter.log("<a href=\""+Testutil.screenshotName+">ScreenShot</a>");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
