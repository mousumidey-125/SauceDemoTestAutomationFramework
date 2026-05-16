package com.saucedemo.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.automation.base.BaseTest;
import com.saucedemo.automation.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void verifyLoginPageTitle() {
		LoginPage loginPage = new LoginPage(driver);
		String title = loginPage.navigateToSauceDemo().getTitle();
		Assert.assertTrue(title.contains("Swag Labs"));
	}

}
