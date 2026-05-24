package com.saucedemo.automation.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.saucedemo.automation.base.AuthenticatedTest;
import com.saucedemo.automation.pages.CartPage;
import com.saucedemo.automation.pages.ProductPage;

public class CartTest extends AuthenticatedTest{
	
	ProductPage productPage;
	CartPage cartPage;
	
	@BeforeClass(alwaysRun = true)
	public void setUpPage() {
		 productPage = new ProductPage(driver);
		 productPage.addToCart();	
		 cartPage = new CartPage(driver);
		 cartPage.navigateToCart();
	}
	
	@Test(groups = {"smoke", "regression"}, priority = 1)
	public void verifyCartHeader() {
		String cartHeader = cartPage.getCartHeader();
		Assert.assertEquals(cartHeader, "Your Cart");
	}
	
	@Test(groups = {"regression"}, priority = 2)
	public void verifyCartItemName() {
		String cartItemName = cartPage.getCartItemName();
		Assert.assertEquals(cartItemName, "Sauce Labs Backpack");
	}
	
	@Test(groups = {"regression"}, priority = 3)
	public void verifyCartItemPrice() {
		String cartItemPrice = cartPage.getCartItemPrice();
		Assert.assertEquals(cartItemPrice, "$29.99");
	}
	
	@Test(groups = {"regression"}, priority = 4)
	public void verifyRemoveItem() {
		cartPage.removeItem();
		Assert.assertTrue(productPage.isCartEmpty());
	}

}
