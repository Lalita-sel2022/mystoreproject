package com.mystore.actiondriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mystore.base.BaseClass;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

public class Action extends BaseClass
{
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public static boolean isEleDisplayed(WebDriver driver, WebElement ele)
	{
		boolean flag = false;
//		//flag = findElement(driver, ele);
//		if (flag) {
//			flag = ele.isDisplayed();
//			if (flag) {
//				System.out.println("The element is Displayed");
//			} else {
//				System.out.println("The element is not Displayed");
//			}
//		} else {
//			System.out.println("Not displayed ");
//		}
//		return flag;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(ele));
		flag=ele.isDisplayed();
		if(flag)
		{
			System.out.println("The element is Displayed");
		}else
		{
			System.out.println("The element is not Displayed");
		}
		return flag;
		
	}
	
	public static void type( WebElement ele, String text)
	{
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static void selectElement(WebElement ele, String seleByValue)
	{
		System.out.println("Element seleted");
		Select sel= new Select(ele);
		sel.selectByVisibleText(seleByValue);
		
	}
	
	public static void sortValue(List<Double> list)
	{
		Collections.sort(list);
		System.out.println("List after sort is ::"+list);
		 
	}
	
	public static  void takeScreenshot() throws IOException 
	{
		Date da= new Date();
		String screenshotFile = da.toString().replace(":", "_").replace(" ", "_")+".png";
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = ExtentManager.screenshotFolder;
		System.out.println("Screenshot path is :: "+destination);

		try {
			FileUtils.copyFile(source, new File(destination+"\\"+screenshotFile));
		} catch (Exception e) {
			e.getMessage();
		}
		
		Log.info("Screenshot --> "+test.addScreenCaptureFromPath(destination+"\\"+screenshotFile));

	}
	public static void reportFailure(String message, boolean stopOnFailure) throws IOException
	{
		softAssert.fail(message);
		Log.fail(message);
		takeScreenshot();
		
		if(stopOnFailure)
			assertAll();
			
	}
	
	public static void assertAll()
	{
		Reporter.getCurrentTestResult().getTestContext().setAttribute("CriticalFailure", "Y");
		softAssert.assertAll();
	}
	

}
