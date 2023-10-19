package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class LoginSession extends BaseClass
{
    public LoginPage loginPage;
    public HomePage homePage;
    
	@Test(dataProvider = "LoginData", dataProviderClass =DataProviders.class, groups = "Smoke")
	public void loginToApp(String userName, String pass)
	{
		//test.log(Status.INFO, "Login.....................");
		Log.startTestCase("loginToApp");
    	loginPage= new LoginPage();
    	Log.info("Enter the user name");
    	loginPage.enterUserName(userName);
    	Log.info("Enter the password");
    	loginPage.enterPass(pass);
    	Log.info("Click on login button");
	    homePage = loginPage.clickLoginBtn();
	    Log.pass("Login is successfull");
	    
//	    boolean logo = homePage.validateLogo();
//	    Log.info("Verify the logo on homepage");
//	    Assert.assertTrue(logo);
//	    Log.info("Login is pass");
//	    if(logo)
//	    {
//	    	Assert.assertTrue(true);
//	    }else
//	    {
//	    	Assert.assertTrue(false);
//	    }
	    Log.endTestCase("loginToApp");
	}
	
	@Test(groups = "Smoke")
	public void logout() throws InterruptedException
	{
		Log.startTestCase("logout");
		 Thread.sleep(5000);
		 
		 loginPage= new LoginPage();
		 Log.info("Enter the user name");
	     loginPage.enterUserName(mainPro.getProperty("username"));
	     Log.info("Enter the Password");
	     loginPage.enterPass(mainPro.getProperty("pass"));
	     Log.info("Click on login button");
		 homePage = loginPage.clickLoginBtn();
		 Thread.sleep(2000);
		 Log.info("Click on three dots");
		 homePage.clickOnThreeDots();
		 Log.info("Click on logout button");
		 loginPage=homePage.clickOnLogout();
		 Log.pass("Logout is pass");
	
	}
}
