package com.saucedemo.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	private static final By cartLink = By.xpath("//a[@class='shopping_cart_link']");
	private static final By cartHeader = By.xpath("//span[text()='Your Cart']");
	private static final By cartItemName = By.xpath("//div[@class='inventory_item_name']");
	private static final By cartItemPrice = By.xpath("//div[@class='inventory_item_price']");
	private static final By remove = By.xpath("//button[text()='Remove']");
	private static final By checkout = By.xpath("//button[text()='Checkout']");
	
	public CartPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public CartPage navigateToCart() {
		driver.findElement(cartLink).click();
		return this;
	}
	
	public String getCartHeader() {
		return driver.findElement(cartHeader).getText();
	}
	
	public String getCartItemName() {
		return driver.findElement(cartItemName).getText();
	}
	
	public String getCartItemPrice() {
		return driver.findElement(cartItemPrice).getText();
	}
	
	public CartPage removeItem() {
		driver.findElement(remove).click();
		return this;
	}
	
	public CartPage clickCheckout() {
		driver.findElement(checkout).click();
		return this;
	}
	
	

}
