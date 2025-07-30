package com.qa.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOne {
	
	private WebDriver driver;
	
	private By title=By.cssSelector(".title");
	private By firstName=By.name("firstName");
	private By lastName=By.id("last-name");
	private By pinCode=By.xpath("(//input[@class='input_error form_input'])[3]");
	private By submitBtn=By.cssSelector("#continue");
	private By cancelBtn=By.xpath("//input[@type='submit']/preceding-sibling::button");
	
	public CheckOutStepOne(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String pageHeaderTitle() {
		
		return driver.findElement(title).getText();
	}
	
	public CheckOutStepTwo getYourInfo(String fname,String lname,String pincode) {
		
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(pinCode).sendKeys(pincode);
		driver.findElement(submitBtn).click();
		return new CheckOutStepTwo(driver);
	}
	
	public CartPage getCancelInfoPage() {
		driver.findElement(cancelBtn).click();
		return new CartPage(driver);
	
	}

}
