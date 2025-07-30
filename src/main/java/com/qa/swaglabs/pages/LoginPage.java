package com.qa.swaglabs.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;


public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	private By userName=By.className("input_error") ;
	private By password=By.cssSelector("#password");
	private By logo=By.xpath("//div[text()='Swag Labs']");
	private By userList=By.xpath("//h4");
	private By loginBtn=By.name("login-button");
	
	
	
	public String getPageTitle() {
		String title=driver.getTitle();
		System.out.println(title );
		return title;
	}
	
    public boolean isLogoPresent() {
		return driver.findElement(logo).isDisplayed();
	}
    
    @Step("Getting list of usernames from login page")
    public List<String> getListofUsernames() {
    	
    	List<WebElement> userListEle=driver.findElements(userList);
    	List<String> userArrList=new ArrayList<String>();
    	
    	for(WebElement e: userListEle) {
    		String usernameList=e.getText();
    		
    		userArrList.add(usernameList);
    		
    		}
    	return userArrList;
    	
    }
    public InventoryPage doLogin(String un,String pwd) {
    	
    	
    	driver.findElement(userName).sendKeys(un);
    	driver.findElement(password).sendKeys(pwd);
    	driver.findElement(loginBtn).click();
    	return new InventoryPage(driver);
    	
    }
}
