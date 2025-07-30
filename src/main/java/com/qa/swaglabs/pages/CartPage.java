package com.qa.swaglabs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	private WebDriver driver;
	
	private By title=By.cssSelector(".title");
	private By cartContainer=By.cssSelector(".cart_item_label div");
	private By checkOut=By.id("checkout");
	
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	      this.driver=driver;
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getpageHeaderTitle() {
		return driver.findElement(title).getText();
		
	}
	
	public void checkCart() {
		List<WebElement> cartCtnr=driver.findElements(cartContainer);
		System.out.println(cartCtnr.size());
		for(WebElement e:cartCtnr) {
			
			String item=e.getText();
			System.out.println(item);
		}
		
	}
	
	public CheckOutStepOne checkoutItems() {
		driver.findElement(checkOut).click();
		return new CheckOutStepOne(driver);
	}
	

}
