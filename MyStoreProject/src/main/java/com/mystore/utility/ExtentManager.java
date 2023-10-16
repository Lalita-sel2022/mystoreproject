package com.mystore.utility;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.base.BaseClass;

public class ExtentManager extends BaseClass
{
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	public static String screenshotFolder; 
	public static ExtentTest test;
	
	public static ExtentReports getReport()
	{
		if(report==null)
		{
			report= new ExtentReports();
			Date d= new Date();
			String reportFolder = d.toString().replace(":", "-").replace(" ", "-")+"\\screenshots";
			screenshotFolder = projectPath+"\\report\\"+reportFolder;
			String reportFoder = projectPath+"\\report\\"+d.toString().replace(":", "-").replace(" ", "-")+"\\MyReport.html";
			File f=new File(screenshotFolder);
			f.mkdirs();
			
			htmlReport = new ExtentHtmlReporter(reportFoder);
			htmlReport.config().setDocumentTitle("Automation test Report");
			htmlReport.config().setReportName("Functional Report");
			htmlReport.config().setTheme(Theme.STANDARD);
			report.attachReporter(htmlReport);
			report.setSystemInfo("HostName", "MyHost");
			report.setSystemInfo("ProjectName", "MyStoreProject");
			report.setSystemInfo("Tester", "Lalita");
			report.setSystemInfo("OS", "Win10");
			report.setSystemInfo("Browser", "Chrome");
			
		}
		return report;
		
	}
	
	public static void endReport()
	{
		report.flush();
	}

}
