package com.mystore.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener extends ExtentManager implements ITestListener
{

	//Action action= new Action();
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

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
