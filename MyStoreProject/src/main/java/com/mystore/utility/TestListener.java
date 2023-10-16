package com.mystore.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;

public class TestListener extends ExtentManager implements ITestListener
{

	//Action action= new Action();
	
	public void onTestStart(ITestResult result) {
		
		Log.info(result.getName() +"   Test Start");
	}

	public void onTestSuccess(ITestResult result) {
		Log.pass("passed "+result.getName());
	}

	public void onTestFailure(ITestResult result) 
	{
	
		String failMessage = result.getThrowable().getMessage();
	    Log.fail(failMessage + MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

		}
	

	public void onTestSkipped(ITestResult result) {
		
		Log.skip("Skipped "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	


}
