package com.saucedemo.automation.base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.saucedemo.automation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	//protected WebDriver driver;
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    protected ConfigReader configReader;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
    	System.out.println("Thread ID: " + Thread.currentThread().getId() + " | Class: " + this.getClass().getSimpleName());
        try {
            configReader = new ConfigReader();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = configReader.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (System.getenv("JENKINS_HOME") != null) {
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
            }
            driverThreadLocal.set(new ChromeDriver(options));
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driverThreadLocal.set(new EdgeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driverThreadLocal.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}