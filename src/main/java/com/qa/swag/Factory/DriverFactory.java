package com.qa.swag.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.swag.exception.FrameworkException;

public class DriverFactory {
	
	public  WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tdlDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop) {
		
		//String browserName= prop.getProperty("browser").trim();
		
		String browserName=System.getProperty("browser");
		
		if(browserName==null || browserName.isEmpty()) {
			if(prop.getProperty("browser")!=null) {
			 browserName= prop.getProperty("browser").toLowerCase().trim();
		    }else {
		    	throw new RuntimeException("Browser is not provided via System property or config properties");
		    }
		}
		
		
		
		if(browserName.toLowerCase().trim().contains("chrome")) {
			
			  
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-save-password-bubble");
			options.addArguments("--guest");
           // options.addArguments("--incognito");
			//options.addArguments("--disable-notifications");
			// Map<String, Object> prefs = new HashMap<>();
			 // prefs.put("credentials_enable_service", false);
			  //prefs.put("profile.password_manager_enabled", false);
			  
			  //options.setExperimentalOption("prefs", prefs);
			 
			
			tdlDriver.set(new ChromeDriver(options)); //set with threadlocal
			
			//driver=new ChromeDriver(options);
		}else if(browserName.trim().contains("firefox")) {
			
			tdlDriver.set(new FirefoxDriver());
			//driver=new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		//driver.get("https://www.saucedemo.com/");
		
		getDriver().manage().window().maximize();
		getDriver().get("https://www.saucedemo.com/");
		
		return getDriver();
		//return driver;
	}
	
	public synchronized static WebDriver getDriver() {
		
		return tdlDriver.get();
		
	}
	
	
	
	public Properties initProp() {
		prop=new Properties();
		FileInputStream ip = null;
		
		String envName=System.getProperty("env");
		System.out.println("Running testcases on Env " + envName);
		
		
		try {
		if(envName == null) {
			System.out.println("No env is passed....Running on QA env");
			ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
		}
		else {

			switch(envName.toLowerCase().trim()) {
			 case "qa" :
				  ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
				 break;
				 
			 case "test" :
				  ip=new FileInputStream("./src/test/resources/config/test.config.properties");
				 break;
				 
			 case "stage" :
				  ip=new FileInputStream("./src/test/resources/config/config.properties");
				 break;
			
			 default:
				 System.out.println("Wrong envrionmnet is passed..... No need to run the test cases");
				 throw new FrameworkException("WRONG ENV NAME IS PASSED...FRAMEWORK EXCEPTION");
				 //break;
			
			
			
			}
			
			
			
		}
		}catch (FileNotFoundException e) { // TODO Auto-generated catch block
			 e.printStackTrace(); 
			 } 
		
		/*
		 * try { //FileInputStream ip=new
		 * FileInputStream("./src/test/resources/config/config.properties");
		 * prop.load(ip);
		 * 
		 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); }
		 */
		 try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return prop;
		 
		
	}

	public static String getScreenshot(String methodName) {
		// TODO Auto-generated method stub
		
		File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destFile=new File(path);
		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
