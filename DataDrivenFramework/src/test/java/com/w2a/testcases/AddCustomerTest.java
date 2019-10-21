package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String PostCode, String alerttext) throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("AddCustBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("AddCustBtn"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("AddCustBtn"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("AddCustBtn"))).sendKeys(PostCode);
		driver.findElement(By.xpath(OR.getProperty("AddBtn"))).click();
		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		 //Assert.assertTrue(alert.getText().contains(alerttext));
		 Thread.sleep(3000);
		 //alert.accept();
		
		 }
	
	
	
	@DataProvider
	public Object [] [] getData()

	{
		String sheetName="AddCustomerTest";
		int rows= excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
	
	Object [] [] data= new Object[rows-1][cols];
	
	for (int rowNum=2;rowNum<=rows;rowNum++)
	{
		for( int colNum=0;colNum<cols;colNum++)
		{
			
			data[rowNum-2][colNum]= excel.getCellData(sheetName, colNum, rowNum);
		
		}	
	}
	 return data;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
