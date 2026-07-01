package com.saucedemo.automation.base;

import org.testng.annotations.BeforeMethod;

import com.saucedemo.automation.pages.LoginPage;

public class AuthenticatedTest extends BaseTest {
	
	LoginPage loginPage;
	
	@BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage = new LoginPage(getDriver());
        loginPage.navigateToSauceDemo()
                 .enterUserName(configReader.getUserName())
                 .enterPassword(configReader.getPassword())
                 .clickLoginButton();
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	

}
