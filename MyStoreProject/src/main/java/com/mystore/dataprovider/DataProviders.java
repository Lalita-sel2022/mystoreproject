package com.mystore.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.base.BaseClass;
import com.mystore.utility.XLUtiles;

public class DataProviders extends BaseClass
{
//	public static String path="C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx";
//	public static  String sheetName="logindata";
//	public int rownum;
//	public int cellnu
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		//C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx";//
		String path= projectPath+"\\testData\\login.xlsx";
		
		System.out.println("File path is : "+path);
		String sheetName="logindata";
		int rownum = XLUtiles.getRowCount(path, sheetName);
		System.out.println(rownum);
		int cellnum = XLUtiles.getCellCount(path, sheetName, 1);
		String loginData[][]= new String[rownum][cellnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				loginData[i-1][j]=XLUtiles.getData(path, sheetName, i, j);
			}
		}
		
		return loginData;
	}
	
	@DataProvider(name="CheckoutInfoData")
	public String[][] getCheckoutInfoData() throws IOException
	{
		//C:\\Users\\adj_2\\OneDrive\\Documents\\login.xlsx";//
				String path= projectPath+"\\testData\\login.xlsx";
				
				System.out.println("File path is : "+path);
				String sheetName="checkoutInfo";
				int rownum = XLUtiles.getRowCount(path, sheetName);
				System.out.println(rownum);
				int cellnum = XLUtiles.getCellCount(path, sheetName, 1);
				System.out.println(cellnum);
				String checkoutInfData[][]= new String[rownum][cellnum];
				for(int i=1;i<=rownum;i++)
				{
					for(int j=0;j<cellnum;j++)
					{
						checkoutInfData[i-1][j]=XLUtiles.getData(path, sheetName, i, j);
					}
				}
				
				return checkoutInfData;
		
	}

}
