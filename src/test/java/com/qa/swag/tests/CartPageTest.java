package com.qa.swag.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class CartPageTest extends BaseTest {
	
	
	@BeforeClass
	
    public void pageSetUp() {
		
		ip=lp.doLogin("standard_user", "secret_sauce");
		ip.addToCart("Sauce Labs Backpack");
		cp=ip.shoppingcartIconClick();
		
		
	}
	
	@Test
	public void getPageTitleTest() {
		String actualTitle=cp.getPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.SWAGLABS_PAGE_TITLE_VALUE);
	}

	@Test
	public void getPageUrlTest() {
		String actualUrl=cp.getPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.CART_PAGE_URL_FRACTION_VALUE));
		
	}
	@Test
	public void getPageHeaderTitleTest() {
		String actualPageHeadertitle=cp.getpageHeaderTitle();
		Assert.assertEquals(actualPageHeadertitle, AppConstants.CART_PAGE_HEADER_TITLE_VALUE);
	}
	@Test
	public void getCheckCart() {
		//ip.addToCart("Sauce Labs Backpack");
		cp.checkCart();
	}
	
	
}
