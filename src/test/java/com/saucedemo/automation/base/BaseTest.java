package com.saucedemo.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.saucedemo.automation.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected ConfigReader configReader;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			configReader = new ConfigReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public WebDriver getDriver() {
	    return driver;
	}

}
