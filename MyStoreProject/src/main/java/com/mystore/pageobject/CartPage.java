package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CartPage extends BaseClass
{
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name']")WebElement productName;
	@FindBy(id="checkout")WebElement checkoutButn;
	
	
	public boolean isProductAvail()
	{
		return Action.isEleDisplayed(driver, productName);
	}
	
	public CheckOutInfo clickCheckoutBtn()
	{
		Action.click(checkoutButn);
		return new CheckOutInfo();
	}

}
