package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.CheckOutInfo;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OverviewPage;

public class OverviewPageTest extends BaseClass
{

	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public  CheckOutInfo checkoutInfo;

	@Test(groups = "Regression")
	public void checkProductToCart()
	{
		loginPage= new LoginPage();
		loginPage.enterUserName(mainPro.getProperty("username"));
    	loginPage.enterPass(mainPro.getProperty("pass"));
	    homePage = loginPage.clickLoginBtn();
	    homePage.AddtoCartProduct();
	    cartPage=homePage.clickOnCart();
	    checkoutInfo = cartPage.clickCheckoutBtn();
	    checkoutInfo.enterFirstName("Lalita");
	    checkoutInfo.enterLastName("Saini");
	    checkoutInfo.enterPostCode("234567");
	    OverviewPage overview = checkoutInfo.clickContinueBtn();
	    double prodPrice = overview.getProductPrice();
	    double totalPrice = overview.getTotalPrice();
	    double totalExpPrice =prodPrice+2.40;
	    System.out.println("totalExpPrice :"+totalExpPrice);
	    Assert.assertEquals(totalPrice, totalExpPrice);
	    
	}
}
