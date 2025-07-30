package com.qa.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwo {
	
	private WebDriver driver;
	private By title=By.cssSelector(".title");
	private By summaryInfo=By.cssSelector(".summary_info");
	private By finishBtn=By.cssSelector("#finish");

	public  CheckOutStepTwo(WebDriver driver) {
		this.driver=driver;
		
		
	}
	
	public String getPageUrl() {
	      return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageHeaderTitle() {
		return driver.findElement(title).getText();
	}
	
	public List<String> getCartSummaryInfo() {
		
		List<WebElement> listSummaryInfo=driver.findElements(summaryInfo);
		List<String> lstSummarInfo=new ArrayList<String>();
		
		for(WebElement info:listSummaryInfo) {
			String summaryInfo=info.getText();
			System.out.println(summaryInfo);
			lstSummarInfo.add(summaryInfo);
		}
		return lstSummarInfo;
	}
	
	public CheckoutComplete getFinishClick() {
		
		driver.findElement(finishBtn).click();
		return new CheckoutComplete(driver);
	}

}
