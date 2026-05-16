package com.saucedemo.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	WebDriver driver;

	private static final By allProducts = By.xpath("//div[@class='inventory_item']");
	private static final By productNames = By.xpath("//div[@class='inventory_item_name ']");
	private static final By addToCart = By.xpath("//button[text()='Add to cart']");
	private static final By cartCount = By.xpath("//span[@class='shopping_cart_badge']");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getProductCount() {
		List<WebElement> allProduct = driver.findElements(allProducts);
		return allProduct.size();
	}
	
	public String getProductName() {
		List<WebElement> productName = driver.findElements(productNames);
		return productName.get(0).getText();
	}
	
	public ProductPage addToCart() {
		List<WebElement> cart = driver.findElements(addToCart);
		cart.get(0).click();
		return this;
	}
	
	public String getCartCount() {
	    return driver.findElement(cartCount).getText();
	}

}
