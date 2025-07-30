package com.qa.swag.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class CheckoutStep1Test extends BaseTest{
	
	@BeforeClass
	public void pageSetUp() {
		ip=lp.doLogin("standard_user", "secret_sauce");
		ip.addToCart("Sauce Labs Backpack");
		cp=ip.shoppingcartIconClick();
		cs1=cp.checkoutItems();
		
	}
	
    @Test
	public void getPageTitleTest() {
		String actualTitle=cs1.getPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.SWAGLABS_PAGE_TITLE_VALUE);
	}
    
    @Test
    public void getPageUrlTest() {
    	String actualUrl=cs1.getPageUrl();
    	Assert.assertTrue(actualUrl.contains(AppConstants.CHECKOUTSTEP1_PAGE_URL_FRACTION_VALUE));
    }
    
    @Test
    public void getPageHeaderTitleTest() {
    	String headerTitle=cs1.pageHeaderTitle();
    	Assert.assertEquals(headerTitle, AppConstants.CHECKOUTSTEP1_PAGE_HEADER_TITLE_VALUE);
    	
    }
    
    @DataProvider
    public Object[] getData() {
    	return  new Object[][] {
    		{"Deeps","dd","L5N322"},
    		
    	};
    }
    
    
    @Test(dataProvider="getData")
    public void getSubmitYourInformationTest(String fname,String lname,String pincode) {
    	cs2=cs1.getYourInfo(fname, lname, pincode);
    	String actualUrl=cs2.getPageUrl();
    	Assert.assertTrue(actualUrl.contains(AppConstants.CHECKOUTSTEP2_PAGE_URL_FRACTION_VALUE));
    }
    
    @Test
    public void getCancelTest() {
    	cp=cs1.getCancelInfoPage();
    	String actualUrl=cp.getPageUrl();
    	Assert.assertTrue(actualUrl.contains(AppConstants.CART_PAGE_URL_FRACTION_VALUE));
    }
}
