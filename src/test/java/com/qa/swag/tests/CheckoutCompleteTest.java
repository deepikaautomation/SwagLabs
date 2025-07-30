package com.qa.swag.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class CheckoutCompleteTest extends BaseTest {
	
	@BeforeClass
	public void pageSetUp() {
		ip=lp.doLogin("standard_user", "secret_sauce");
		ip.addToCart("Sauce Labs Backpack");
		cp=ip.shoppingcartIconClick();
		cs1=cp.checkoutItems();
		cs2=cs1.getYourInfo("DDD", "OOO", "8666FF");
		cc=cs2.getFinishClick();
		
	}
	
	@Test
	public void getConfirmationCheckTest() {
		
		String actualCnfmMsg=cc.getConfirmationMsg();
		Assert.assertEquals(actualCnfmMsg, "Thank you for your order!");
	}
	
	@Test
	public void getBackHomeTest() {
		ip=cc.getBackHomeClick();
		String actualIpUrl=ip.getPageUrl();
		Assert.assertTrue(actualIpUrl.contains(AppConstants.INVENTORY_PAGE_URL_FRACTION_VALUE));
	}

}
