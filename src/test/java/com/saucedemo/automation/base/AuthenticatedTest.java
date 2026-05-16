package com.saucedemo.automation.base;

import org.testng.annotations.BeforeClass;

import com.saucedemo.automation.pages.LoginPage;

public class AuthenticatedTest extends BaseTest {
	
	LoginPage loginPage;
	
	@BeforeClass
    public void login() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToSauceDemo()
                 .enterUserName(configReader.getUserName())
                 .enterPassword(configReader.getPassword())
                 .clickLoginButton();
    }

}
