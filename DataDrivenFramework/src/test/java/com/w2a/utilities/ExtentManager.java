package com.w2a.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	public static ExtentReports getInstance(){
		if(extent==null){
			extent= new ExtentReports("F:\\Softwares\\Eclipse NeonWorkspace\\DataDrivenFramework\\target\\surefire-reports\\html", true,DisplayOrder.OLDEST_FIRST);	
			extent.loadConfig(new File("F:\\Softwares\\Eclipse NeonWorkspace\\DataDrivenFramework\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
