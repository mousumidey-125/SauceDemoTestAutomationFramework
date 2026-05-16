package com.saucedemo.automation.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.saucedemo.automation.base.AuthenticatedTest;
import com.saucedemo.automation.pages.ProductPage;

public class ProductTest extends AuthenticatedTest{
	
	ProductPage productPage;
	@BeforeMethod
	public void setupPage() {
	    productPage = new ProductPage(driver);
	}
	
	@Test
	public void verifyProductCount() {
		int productCount = productPage.getProductCount();
		Assert.assertEquals(productCount, 6);
		
	}
	
	@Test
	public void verifyFirstProductName() {
		String productname = productPage.getProductName();
		Assert.assertEquals(productname, "Sauce Labs Backpack");
		
	}
	
	@Test
	public void verifyAddToCart() {
		String cartCount = productPage.addToCart().getCartCount();
		Assert.assertEquals(cartCount, "1");
		
	}
	

}
