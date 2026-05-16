package com.saucedemo.automation.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void navigateLoginPage() {
		loginPage = new LoginPage(driver);
		loginPage.navigateToSauceDemo();
	}
	
	@Test
	public void verifyLoginPageTitle() {
		String title = loginPage.getTitle();
		Assert.assertTrue(title.contains("Swag Labs"));
	}
	
	@Test
	public void verifySuccessfulLogin() {
		String header = loginPage.enterUserName(configReader.getUserName())
				                 .enterPassword(configReader.getPassword())
				                 .clickLoginButton()
				                 .pageHeaderText();
		
		Assert.assertTrue(header.contains("Products"));
				
	}

}
