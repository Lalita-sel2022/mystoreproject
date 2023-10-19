package com.mystore.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	
	public List<Double> beforFiltList=null;
	public List<Double> afterFiltList;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='app_logo']") WebElement appLogo;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")WebElement addToCartButton;
	@FindBy(xpath="//a[@class='shopping_cart_link']")WebElement CartButton;
	@FindBy(id="react-burger-menu-btn")WebElement threeDots;//logout_sidebar_link
	@FindBy(id="logout_sidebar_link")WebElement logoutButton;
	@FindBy(xpath="//div[@class='inventory_list']/div") List<WebElement> products;
	@FindBy(xpath="//div[@class='inventory_item_price']")List<WebElement> beforeFilterPrices;
	@FindBy(xpath="//div[@class='inventory_item_price']")List<WebElement> afterFilterPrices;
	
	@FindBy(xpath="//select[@class='product_sort_container']")WebElement selectDropdown;
	
	
	public String validateLogo()
	{
		//return Action.isEleDisplayed(driver, appLog);
		String logo = appLogo.getText();
		return logo;
	}
	
	public void AddtoCartProduct()
	{
		Action.click(addToCartButton);
	}
	
	public CartPage clickOnCart()
	{
		Action.click(CartButton);
		return new CartPage();
	}
	
	public void clickOnThreeDots()
	{
		Action.click(threeDots);
	
	}
	
	public LoginPage clickOnLogout()
	{
		Action.click(logoutButton);
		return new LoginPage();
	}
	
	public void getBeforeFilterPrices()
	{
		System.out.println("beforeFilterPrices :: "+beforeFilterPrices.size());
		beforFiltList= new ArrayList();
		for( WebElement p:beforeFilterPrices)
		{
			beforFiltList.add(Double.valueOf(p.getText().replace("$", "")));
			
		}
	}
//	
//	public void selectDropdown()
//	{
//		Action.selectElement(selectDropdown, "Price (low to high)");
//		
//	}
	
	public void getAfterFilterPrices()
	{
		Action.selectElement(selectDropdown, "Price (low to high)");
		System.out.println("afterFilterPrices :: "+afterFilterPrices.size());
		afterFiltList= new ArrayList();
		for(WebElement q:afterFilterPrices)
		{
			afterFiltList.add(Double.valueOf(q.getText().replace("$", "")));
			
		}
	}
	
	public boolean sortAndCompareValue()
	{
		Action.sortValue(beforFiltList);
		System.out.println("sortAndCompareValue :: "+beforFiltList);
		System.out.println("afterFiltList :: "+afterFiltList);
		if(afterFiltList.equals(beforFiltList))
		{
			System.out.println("condition true beforFiltList"+beforFiltList);
			return true;
		}
		else {
			System.out.println("false");
		    return false;
		}
	}
}
