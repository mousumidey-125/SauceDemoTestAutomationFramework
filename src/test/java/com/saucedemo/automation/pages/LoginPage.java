package com.saucedemo.automation.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}
	
	public LoginPage navigateToSauceDemo() {
		driver.navigate().to("https://www.saucedemo.com/");
		return this;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

}
