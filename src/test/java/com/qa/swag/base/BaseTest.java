package com.qa.swag.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.swag.Factory.DriverFactory;
import com.qa.swaglabs.pages.CartPage;
import com.qa.swaglabs.pages.CheckOutStepOne;
import com.qa.swaglabs.pages.CheckOutStepTwo;
import com.qa.swaglabs.pages.CheckoutComplete;
import com.qa.swaglabs.pages.InventoryPage;
import com.qa.swaglabs.pages.LoginPage;

public class BaseTest {
    WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	
	protected LoginPage lp;
	protected InventoryPage ip;
	protected CartPage cp;
	protected CheckOutStepOne cs1;
	protected CheckOutStepTwo cs2;
	protected CheckoutComplete cc;
	
	@BeforeTest
	public void setUp() {
		
		df=new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		cp=new CartPage(driver);
		
	
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
}
