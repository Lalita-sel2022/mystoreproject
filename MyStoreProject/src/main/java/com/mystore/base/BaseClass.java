package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

//Accepted failur, critical failure, unexpected failure
public class BaseClass {
	
	public static WebDriver driver;
	public static Properties mainPro;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream file;
	public static ExtentReports report;
	public static ExtentTest test;
	public static SoftAssert softAssert;

	
	@BeforeTest( groups = {"Smoke","Regression", "Sanity"})
	public void beforeClass(ITestContext context) throws IOException
	{
		file= new FileInputStream(projectPath+"\\src\\test\\resources\\prod.properties");
		mainPro= new Properties();
		mainPro.load(file);
		String value = mainPro.getProperty("chromebrowser");
		System.out.println("Property vaue is ::"+value);
		
	
		report = ExtentManager.getReport();
		test = report.createTest(context.getCurrentXmlTest().getName());
		
	
		context.setAttribute("report", report);
		context.setAttribute("test", test);
		
		//Configure log4j file
		file= new FileInputStream(projectPath+"\\src\\test\\resources\\log4j.properties");
		PropertyConfigurator.configure(file);
		softAssert= new SoftAssert();
		
		
	}
	
	


	public static void launchBrowser(String browser)
	{
		//String value = mainPro.getProperty("chromebrowser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\adj_2\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");//C:\Users\adj_2\Downloads\chromedriver-win64 (1)\chromedriver-win64
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*"); 
	        driver= new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		}
		
		else if(browser.equals("edge"))
		{
		   WebDriverManager.edgedriver().setup();
		   driver= new EdgeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		}
	}
	
	public static void navigateUrl()
	{
		driver.get(mainPro.getProperty("url"));
	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Regression", "Sanity"})
	public void beforeMethod(String browser, ITestContext context)
	{	
		String criticalFailure = (String)context.getAttribute("CriticalFailure");
		if(criticalFailure!=null && criticalFailure.equals("Y"))
		{
			Log.skip("critical Failure in previous test");
			throw new SkipException("critical Failure in previous test");
			
		}
		launchBrowser(browser);
		navigateUrl();
	    report=(ExtentReports)context.getAttribute("report");
		test=(ExtentTest)context.getAttribute("test");
	}
	
	@AfterTest
	public void afterTest()
	{
		if(report!=null)
		{
		ExtentManager.endReport();
		}
	}
	
//	public static ExtentTest getTest(ExtentTest test)
//	{
//		return test;
//		
//	}
}
