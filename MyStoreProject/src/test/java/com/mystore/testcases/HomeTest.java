package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class HomeTest extends BaseClass
{
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	
	@Test(groups = {"Regression", "Sanity"})
	public void addToCartProduct()
	{
		Log.startTestCase("addToCartProduct");
		loginPage= new LoginPage();
		Log.info("Enter the user name");
		loginPage.enterUserName(mainPro.getProperty("username"));
		Log.info("Enter the Password");
    	loginPage.enterPass(mainPro.getProperty("pass"));
    	Log.info("Click on login button");
	    homePage = loginPage.clickLoginBtn();
	    Log.info("Click on add to cart button");
	    homePage.AddtoCartProduct();
//	    cartPage = homePage.clickOnCart();
//	    boolean carAvail = cartPage.isProductAvail();
//	    Assert.assertTrue(carAvail);
//	    if(carAvail)
//	    {
//	    	Assert.assertTrue(true);
//	    }else
//	    {
//	    	Assert.assertTrue(false);
//	    }
	}
	
	@Test(groups = "Smoke")
	public void validateLogo()
	{
		Log.startTestCase("validateLogo");
		loginPage= new LoginPage();
		Log.info("Enter the user name");
		loginPage.enterUserName(mainPro.getProperty("username"));
		Log.info("Enter the Password");
    	loginPage.enterPass(mainPro.getProperty("pass"));
    	Log.info("Click on login button");
    	homePage=loginPage.clickLoginBtn();
    	//Log.info("Validate the logo");
    	String val=homePage.validateLogo();
    	Assert.assertEquals(val, "Swag Labs");
    	Log.info("Test is  passed");
    
	}
   	
	
//	public void checkProductToCart()
//	{
//		loginPage= new LoginPage();
//		loginPage.enterUserName(mainPro.getProperty("username"));
//    	loginPage.enterPass(mainPro.getProperty("pass"));
//	    homePage = loginPage.clickLoginBtn();
//	    cartPage=homePage.clickOnCart();
//	    boolean carAvail = cartPage.isProductAvail();
//	    Assert.assertTrue(carAvail);
//	}
	
	@Test(groups = "Regression")
	public void validateSortLowToHigh()
	{
		loginPage= new LoginPage();
		loginPage.enterUserName(mainPro.getProperty("username"));
    	loginPage.enterPass(mainPro.getProperty("pass"));
	    homePage = loginPage.clickLoginBtn();
	    homePage.getBeforeFilterPrices();
	    homePage.getAfterFilterPrices();
	    boolean value = homePage.sortAndCompareValue();
	    System.out.println(value);
	    Assert.assertTrue(value);
	}

}
