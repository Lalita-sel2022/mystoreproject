package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.CheckOutInfo;
import com.mystore.pageobject.CompeletePage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OverviewPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass
{
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public  CheckOutInfo checkoutInfo;
	public  CompeletePage complete;

	@Test(groups = "Regression")
	public void checkProductToCart() throws IOException
	{
		Log.startTestCase("checkProductToCart");
		loginPage= new LoginPage();
		Log.info("Enter the username");
		
		//test.log(Status.INFO, "Enter the username");
		loginPage.enterUserName(mainPro.getProperty("username"));
		Action.reportFailure("Password is not valid", false);
		//Log.info("Enter the password");
		//test.log(Status.INFO, "Enter the password");
    	loginPage.enterPass(mainPro.getProperty("pass"));
    	Log.info("Click on login button");
    	//test.log(Status.INFO, "Click on login button");
	    homePage = loginPage.clickLoginBtn();
	    Log.info("Click on add to cart button");
	    //test.log(Status.INFO, "Click on add to cart button");
	    homePage.AddtoCartProduct();
	    Log.info("Click on cart");
	    //test.log(Status.INFO, "Click on cart");
	    cartPage=homePage.clickOnCart();
	    Log.info("Click on checkout button");
	    //test.log(Status.INFO, "Click on checkout button");
	    checkoutInfo = cartPage.clickCheckoutBtn();
	    Log.info("Enter the first name");
	    //test.log(Status.INFO, "Enter the first name");
	    checkoutInfo.enterFirstName("Lalita");
	    Log.info("Enter the last name");
	   //test.log(Status.INFO, "Enter the last name");
	    checkoutInfo.enterLastName("Saini");
	    Log.info("Enter the postcode");
	    //test.log(Status.INFO, "Enter the postcode");
	    checkoutInfo.enterPostCode("234567");
	    Log.info("Click on continue button");
	    //test.log(Status.INFO, "Click on continue button");
	    OverviewPage overview = checkoutInfo.clickContinueBtn();
//	    double prodPrice = overview.getProductPrice();
//	    double totalPrice = overview.getTotalPrice();
//	    double totalExpPrice =prodPrice+2.40;
//	    System.out.println("totalExpPrice :"+totalExpPrice);
//	    Assert.assertEquals(totalPrice, totalExpPrice);
	    Log.info("Click on finish button");
	    //test.log(Status.INFO, "Click on finish button");
	    complete = overview.clickOnFinshButton();
	    String actaulMess = complete.validateSuccessMessage();
	    Assert.assertEquals(actaulMess, "Thank you for your order!");
	    Log.pass("Order has been successfully");
	    //test.log(Status.PASS, "Order has been successfully");
	     Action.assertAll();
	    
	}

}
