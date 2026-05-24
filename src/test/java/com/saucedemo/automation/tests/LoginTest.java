package com.saucedemo.automation.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.LoginPage;
import com.saucedemo.automation.utils.DataProviders;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
	@BeforeMethod(alwaysRun = true)
	public void navigateLoginPage() {
		loginPage = new LoginPage(driver);
		loginPage.navigateToSauceDemo();
	}
	
	@Test(groups = {"smoke" , "regression"})
	public void verifyLoginPageTitle() {
		String title = loginPage.getTitle();
		Assert.assertTrue(title.contains("Swag Labs"));
	}
	
	@Test(groups = {"regression"})
	public void verifySuccessfulLogin() {
		String header = loginPage.enterUserName(configReader.getUserName())
				                 .enterPassword(configReader.getPassword())
				                 .clickLoginButton()
				                 .pageHeaderText();
		
		Assert.assertTrue(header.contains("Products"));
				
	}
	
	@Test(groups = {"regression"}, dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void verifyLoginWithMultipleUsers(String username, String password, String expectedResult) {
		loginPage.enterUserName(username).enterPassword(password).clickLoginButton();
		
		if(expectedResult.equals("success")) {
			Assert.assertTrue(loginPage.pageHeaderText().contains("Products"));
		}else {
			Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
		}
	}

}
