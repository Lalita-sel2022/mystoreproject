package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.CheckOutInfo;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class CheckoutInfoTest extends BaseClass
{

	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public  CheckOutInfo checkoutInfo;

	@Test(dataProvider = "CheckoutInfoData", dataProviderClass = DataProviders.class, groups = "Regression")
	public void checkProductToCart(String fName, String lName, String postCode)
	{
		Log.startTestCase("checkProductToCart");
		loginPage= new LoginPage();
		Log.info("Enter user name");
		loginPage.enterUserName(mainPro.getProperty("username"));
		Log.info("Enter password");
    	loginPage.enterPass(mainPro.getProperty("pass"));
    	Log.info("Click on login button");
	    homePage = loginPage.clickLoginBtn();
	    Log.info("Click on add to cart button");
	    homePage.AddtoCartProduct();
	    cartPage=homePage.clickOnCart();
	    Log.info("Click on checkout button");
	    checkoutInfo = cartPage.clickCheckoutBtn();
	    Log.info("Enter first name");
	    checkoutInfo.enterFirstName(fName);
	    Log.info("Enter last name");
	    checkoutInfo.enterLastName(lName);
	    Log.info("Enter post code");
	    checkoutInfo.enterPostCode(postCode);
//	    Log.info("Click on continue button");
//	    OverviewPage overview = checkoutInfo.clickContinueBtn();
//	    Log.info("Test is pass");
	  
	    
	}
}
