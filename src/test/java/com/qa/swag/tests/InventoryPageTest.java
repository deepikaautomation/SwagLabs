package com.qa.swag.tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class InventoryPageTest extends BaseTest {
	
	@BeforeClass
	public void pageSetUp() {
		ip=lp.doLogin("standard_user", "secret_sauce");
		
		
	}
	
	@Test
	public void getPageTitleTest() {
		String actualTitle=ip.getPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.SWAGLABS_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void getPartialUrlTest() {
		String actualUrl=ip.getPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.INVENTORY_PAGE_URL_FRACTION_VALUE));
	}
	
	@Test
	public void getLogoTitletest() {
		
		Assert.assertTrue(ip.getLogoTitle());
		
	}
	
	@Test
	public void getItemTest() {
		List<String> items=ip.getInventoryItem();
		int itemCnt=items.size();
		Assert.assertEquals(itemCnt, AppConstants.INVENTORY_PAGE_INVETORY_ITEM_COUNT);
		
	}
	
	@Test
	public void getItemSortTest() {
		ip.itemSort("Price (low to high)");
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			
			{"Sauce Labs Backpack"}
			
		};
		
	}
	
	
	@Test(dataProvider="getData")
	public void  getItemCheckinCartTest(String itemName) {
		
		String actualTest=ip.addToCart(itemName);
		
		System.out.println(actualTest);
		
	}
	
	@Test
	public void getCheckifCartUpdated() {
		ip.checkCartUpdated("Sauce Labs Backpack");
		
	}
	
	@Test
	public void getToCartShoppingPage() {
		cp=ip.shoppingcartIconClick();
		String actualUrl=cp.getPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.CART_PAGE_URL_FRACTION_VALUE));
		
	}
}
