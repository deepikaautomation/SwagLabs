package com.qa.swag.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.swag.base.BaseTest;
import com.qa.swag.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void pageTitleTest() {
		
		String actualTitle=lp.getPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.SWAGLABS_PAGE_TITLE_VALUE);
		
		
	}
	@Test
	public void LogoExistTest() {
		Assert.assertTrue(lp.isLogoPresent());
	}
	
	
	/*
	 * @Test public void userListTest() {
	 * 
	 * List<String> actualUserList=lp.getListofUsernames();
	 * Assert.assertEquals(actualUserList.size(),
	 * AppConstants.LOGINPAGE_USERNAME_SIZE);
	 * 
	 * }
	 */
	
	@Test
	public void doLoginTest() {
		//lp.doLogin("standard_user", "secret_sauce");
		ip=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String actualIpUrl=ip.getPageUrl();
		Assert.assertTrue(actualIpUrl.contains(AppConstants.INVENTORY_PAGE_URL_FRACTION_VALUE));
	}

}
