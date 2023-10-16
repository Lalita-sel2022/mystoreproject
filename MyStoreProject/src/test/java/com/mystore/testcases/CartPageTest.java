package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class CartPageTest extends BaseClass
{
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;

	@Test(groups = {"Smoke", "Sanity", "Regression"})
	public void checkProductToCart()
	{
		
		
		Log.startTestCase("checkProductToCart");
		loginPage= new LoginPage();
		Log.info("Enter username");
		loginPage.enterUserName(mainPro.getProperty("username"));
		Log.info("Enter password");
    	loginPage.enterPass(mainPro.getProperty("pass"));
    	Log.info("click on login button");
	    homePage = loginPage.clickLoginBtn();
	    Log.info("Add product to cart");
	    homePage.AddtoCartProduct();
	    Log.info("Click on cart button");
	    cartPage=homePage.clickOnCart();
	    boolean carAvail = cartPage.isProductAvail();
	    Assert.assertTrue(carAvail);
	    Log.pass("Product is available in cart page");
	   // cartPage.clickCheckoutBtn();
	}
}
