package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.w2a.base.TestBase;

public class Testutil extends TestBase {
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenShot() throws IOException
	{
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileHandler.copy(scrFile,
				new File("F:\\Softwares\\Eclipse NeonWorkspace\\DataDrivenFramework\\target\\surefire-reports\\html\\" + screenshotName));
	}
	
	

}
