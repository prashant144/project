package com.w2a.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		test= rep.startTest(arg0.getName().toUpperCase());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing ScreenShot Runtime");
		Reporter.log("<a href=\""+Testutil.screenshotName+">ScreenShot</a>");
		
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+"FAIL");
		test.log(LogStatus.FAIL,test.addScreenCapture(Testutil.screenshotName));
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		TestBase.test.log(LogStatus.PASS, arg0.getName().toUpperCase()+"PASS");
		rep.endTest(test);
		rep.flush();
	}

}
