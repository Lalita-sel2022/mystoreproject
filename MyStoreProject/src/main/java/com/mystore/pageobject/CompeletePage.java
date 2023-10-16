package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CompeletePage extends BaseClass {
	
	public CompeletePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h2[@class='complete-header']")WebElement finshMessage;
	@FindBy(id="back-to-products")WebElement backHome;
	
	public String validateSuccessMessage()
	{
		String succMesz = finshMessage.getText();
		return succMesz;
		
		//return Action.isEleDisplayed(driver, finshMessage);
	}
	
	public HomePage backToHome()
	{
		Action.click(backHome);
		return new HomePage();
	}
}
