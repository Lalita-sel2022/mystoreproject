package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass
{
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userName;
	@FindBy(id="password") 
	WebElement password;
	@FindBy(id="login-button") 
	WebElement loginButton;
	
	public void enterUserName(String user)
	{
		Action.type(userName, user);
	}
	public void enterPass(String pass)
	{
		Action.type(password, pass);
	}
	
	public HomePage clickLoginBtn()
	{
		Action.click(loginButton);
		return new HomePage();
	}

}
