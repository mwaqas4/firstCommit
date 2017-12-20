package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class eKomiConnect_Login extends configuration  {
  @Test
  public void ekomi_connect(){
	  browser();
	  
	  File file = new File("G:/eclipse_Testing_Automation/sff_Automation/sff_Automation/src/data.properties");
	  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	  WebDriver chrome = new ChromeDriver();
	    
	 // chrome.get("https://sff.coeus-solutions.de/user/login");
	  //wait
		chrome.get(prop.getProperty("URL_Live"));
	  String winHandleBefore = chrome.getWindowHandle();
	    chrome.findElement(By.xpath(prop.getProperty("eKomi_connect_button"))).click();
	    
	 // Switch to new window opened
		 for(String winHandle : chrome.getWindowHandles()){
		     chrome.switchTo().window(winHandle);
		 }
	                //--Perform your operation here for new window
	        	   	//chrome.get("https://ekomi-connect-staging-1.ekomiapps.de/oauth/v2/auth/login");
	        	   	String title = chrome.getTitle();
	     
	        		System.out.println(title);
	        		
	        		 chrome.findElement(By.id("_username")).sendKeys(prop.getProperty("shop"));
	        		 chrome.findElement(By.name("_password")).sendKeys(prop.getProperty("password"));
	        		 chrome.findElement(By.xpath(".//*[@id='_submit']")).click();
	        		 chrome.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	        		 
	        		 chrome.switchTo().window(winHandleBefore);
	        		 
	        		 String URL = chrome.getCurrentUrl();
	        		 
	        			if(URL.equalsIgnoreCase("https://smartforms.ekomi.com/home"))
	        			   System.out.println("test passed with URL");
	        			else
	        				System.out.println("test failed---- Not logged in");
	        		
	        		
  }
}
