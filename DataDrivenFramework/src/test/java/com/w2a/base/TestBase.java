package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config =new Properties();
	public static Properties OR =new Properties();
	public static FileInputStream fis;
	public static Logger log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep= ExtentManager.getInstance();
	public static ExtentTest test;
	@BeforeSuite
	public void setUp(){
		if (driver==null)
		{
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config File Loaded !!!!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.Properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file Loaded !!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if (config.getProperty("browser").equals("firefox"))
			{
				//System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver= new FirefoxDriver();
			}else if ((config.getProperty("browser").equals("chrome"))) {
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver= new ChromeDriver();
				log.debug("Chrome Launched !!!!!!");
			}
			
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to:" + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait= new WebDriverWait(driver, 15);
			
		}
		
	}
	
	public boolean isElementPresent(By by)
	{
		try 
		{
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	
	
	
	@AfterSuite
	public void tearDown(){
		
	if(driver!= null)
	{
		driver.quit();
		log.debug("Test Execution Completed !!!!");
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
