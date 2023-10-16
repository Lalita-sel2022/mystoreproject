package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class CheckOutInfo extends BaseClass
{

	public CheckOutInfo()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first-name")WebElement firstName;
	@FindBy(id="last-name")WebElement lastName;
	@FindBy(id="postal-code")WebElement postCode;//continue
	@FindBy(id="continue")WebElement continueButton;
	
	public void enterFirstName(String fName)
	{
		Action.type(firstName, fName);
	}
	public void enterLastName(String lname)
	{
		Action.type(lastName, lname);
	}
	public void enterPostCode(String code)
	{
		Action.type(postCode, code);
	}
	public OverviewPage clickContinueBtn()
	{
		Action.click(continueButton);
		return new OverviewPage();
	}

}
