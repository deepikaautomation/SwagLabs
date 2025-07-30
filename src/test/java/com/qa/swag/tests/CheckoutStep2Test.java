package com.qa.swag.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class CheckoutStep2Test extends BaseTest {
	@BeforeClass
	public void pageSetUp() {
		ip=lp.doLogin("standard_user", "secret_sauce");
		ip.addToCart("Sauce Labs Backpack");
		cp=ip.shoppingcartIconClick();
		cs1=cp.checkoutItems();
		cs2=cs1.getYourInfo("DDD", "OOO", "8666FF");
		
	}
	
	
    @Test
	public void getPageTitleTest() {
		String actualTitle=cs2.getPageTitle();
		Assert.assertEquals(actualTitle, "Swag Labs");
	}
    
    @Test
    public void getPageUrlTest() {
    	String actualUrl=cs2.getPageUrl();
    	Assert.assertTrue(actualUrl.contains(AppConstants.CHECKOUTSTEP2_PAGE_URL_FRACTION_VALUE));
    }
    
    @Test
    public void getPageHeaderTitleTest() {
    	String headerTitle=cs2.getPageHeaderTitle();
    	Assert.assertEquals(headerTitle, AppConstants.CHECKOUTSTEP2_PAGE_HEADER_TITLE_VALUE);
    	
    }
    
    @Test
    public void getSummaryInfoTest() {
    	List<String> actual=cs2.getCartSummaryInfo();
    	for(String e: actual) {
    		System.out.println(e);
    	}
    	
    }
    
    

}
