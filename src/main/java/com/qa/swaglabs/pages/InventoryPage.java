package com.qa.swaglabs.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
	
	private WebDriver driver;
	
	private By logoTitle=By.cssSelector(".title");
	private By item=By.cssSelector(".inventory_item_name");
	private By selItem=By.className("product_sort_container");
	private By priceBar=By.className("pricebar");
	private By addtoCart=By.cssSelector(".pricebar button");
	private By remove=By.xpath("//button[text()='Remove']");
	private By shopingCartLink=By.cssSelector(".shopping_cart_link");
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getPageTitle() {
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	
	public String getPageUrl() {
		String url=driver.getCurrentUrl();
		return url;
	}

	public boolean getLogoTitle() {
	    return driver.findElement(logoTitle).isDisplayed();
	}
	
	public List<String> getInventoryItem() {
		
		List<WebElement> item=driver.findElements(By.cssSelector(".inventory_item_name"));
		List<String> itemList=new ArrayList<String>();
		
		for(WebElement e: item) {
			String text=e.getText();
			itemList.add(text);
		}
		System.out.println("Item count" + itemList.size());
		return itemList;
		
	}
	
	public void itemSort(String text) {
		WebElement selitemEle=driver.findElement(selItem);
		Select sel=new Select(selitemEle);
		sel.selectByVisibleText(text);
		
	}
	
	public String addToCart(String text)  {
		System.out.println(driver.findElement(addtoCart).getText());
		//int cnt=0;
		List<String> items=getInventoryItem();
		for(String item: items) {
			
			 if(item.equalsIgnoreCase(text)){
				 System.out.println("item found" + item);
				 driver.findElement(addtoCart).click();
			 }
				 //while(itemCnt>0) {
				 
				 
				 //itemCnt--;
				
				 //}
					/*
					 * WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
					 * wait2.until(ExpectedConditions.presenceOfElementLocated(shopingCartLink));
					 * String cartCount=driver.findElement(shopingCartLink).getText();
					 * cnt=Integer.parseInt(cartCount); if(cnt>=1) {
					 * System.out.println("Item added in the cart"); }
					 */
				 // }
			
			
		}
		return "Item added in the cart " + text  ;
		}
	
	
	public void checkCartUpdated(String text) {
		String textItem=addToCart(text);
		System.out.println(textItem);
		 WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait2.until(ExpectedConditions.presenceOfElementLocated(shopingCartLink));
		 String cartCount=driver.findElement(shopingCartLink).getText();
		 
		 if(!cartCount.isEmpty()) {
			 int cartItemCount=Integer.parseInt(cartCount);
			 System.out.println("Cart is not empty ");
		 }else {
			 System.out.println("Cart text was empty");
		 }
		 //cnt=Integer.parseInt(cartCount); if(cnt>=1) {
		 //System.out.println("Item added in the cart"); }
	}
	
	
	
	
	
		/*
		 * public void shoppingCart() { driver.findElement(addtoCart).click();
		 * WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * wait1.until(ExpectedConditions.presenceOfElementLocated(remove));
		 * 
		 * String cartCount=driver.findElement(shopingCartLink).getText(); int
		 * cnt=Integer.parseInt(cartCount); if(cnt>=1) {
		 * System.out.println("Item added in the cart"); }
		 * 
		 * }
		 */
	
	public CartPage shoppingcartIconClick() {
		driver.findElement(shopingCartLink).click();
		return new CartPage(driver);
	}
	
	
}
