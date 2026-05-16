package com.saucedemo.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties properties = new Properties();
	
	public ConfigReader() throws IOException{
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		properties.load(fis);
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getUserName() {
		return properties.getProperty("username");
	}
	
	public String getPassword() {
		return properties.getProperty("password");
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}

}
