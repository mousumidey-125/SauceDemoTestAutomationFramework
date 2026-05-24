package com.saucedemo.automation.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData(){
		ExcelReader excelReader = new ExcelReader("src/test/resources/LoginTestData.xlsx", "LoginData");
		return excelReader.getTestData();
	}

}
