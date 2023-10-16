package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OverviewPage extends BaseClass 
{
	
	public OverviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='summary_subtotal_label']")WebElement productPrice;
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")WebElement totalPrice;
	@FindBy(id="finish")WebElement finshButton;
	
	public double getProductPrice()
	{
		String price = productPrice.getText().replace("$", "");
		//System.out.println(price); 
		String[] splitStr=price.split(":");
		//System.out.println(splitStr[1]); 
		double proPrice = Double.parseDouble(splitStr[1]);
		System.out.println("proPrice :: "+proPrice);
		return proPrice;
	}
	
	public double getTotalPrice()
	{
		String total = totalPrice.getText();
		//System.out.println("Total :"+total);
		String[] splitvalue = total.split(" ");
		//System.out.println(splitvalue[1]);
		double totalPrice = Double.parseDouble(splitvalue[1].replace("$", ""));
		System.out.println("totalPrice :: "+totalPrice);
		return totalPrice;
	}
	
	public CompeletePage clickOnFinshButton()
	{
		Action.click(finshButton);
		return new CompeletePage();
	}

}
