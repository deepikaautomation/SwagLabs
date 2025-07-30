package com.qa.swaglabs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutComplete {
	
	private WebDriver driver;
	private By confrmMsg=By.xpath("//h2[@class='complete-header']");
	private By backHmBtn=By.xpath("//button[text()='Back Home']");
	
	public CheckoutComplete(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public String getConfirmationMsg() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.urlContains("checkout-complete"));
		WebElement confrm=wait.until(ExpectedConditions.visibilityOfElementLocated(confrmMsg));
		//String msg= driver.findElement(confrmMsg).getText();
				String msg=confrm.getText();
		System.out.println(msg);
		return msg;
	}
	
	
	public InventoryPage getBackHomeClick() {
		driver.findElement(backHmBtn).click();
		return new InventoryPage(driver);
	}

}
