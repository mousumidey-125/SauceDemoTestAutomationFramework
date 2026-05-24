package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	private static final By userName = By.xpath("//input[@id='user-name']");
	private static final By password = By.xpath("//input[@id='password']");
	private static final By loginButton = By.xpath("//input[@id='login-button']");
	private static final By pageHeader = By.xpath("//span[@class='title']");
	private static final By errorMessage = By.xpath("//h3[@data-test='error']");

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
	
	public LoginPage enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		return this;
	}
	
	public LoginPage clickLoginButton() {
		driver.findElement(loginButton).click();
		return this;
	}
	
	public String pageHeaderText() {
		return driver.findElement(pageHeader).getText();	
	}
	
	public String getErrorMessage() {
	    return driver.findElement(errorMessage).getText();
	}

}
