package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;

public class Edit_Form extends eKomiConnect_Login{
 
@Test
  public void Edit_Form() {
	
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
		
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		//WebDriver chrome = new ChromeDriver();
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-infobars");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-web-security");
	    options.addArguments("--no-proxy-server");
	    options.addArguments("--enable-automation");
	    options.addArguments("--disable-save-password-bubble");

	    HashMap<String, Object> prefs = new HashMap<String, Object>();
	   
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);

	   
		 
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver chrome = new ChromeDriver(capabilities);
		
/*		chrome.get(prop.getProperty("URL_Live"));
		chrome.findElement(By.id("shop_id")).sendKeys(prop.getProperty("shop"));
		chrome.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button")).click();         
		chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
*/		
		
		ekomi_connect();
		String pagetitle = chrome.getTitle();
		System.out.println("Page titel is " + pagetitle);
		chrome.getCurrentUrl();
		
		String mainWinHandle = chrome.getWindowHandle();
		chrome.findElement(By.xpath(".//*[@id='table-listings']/table/tbody/tr[1]/td[5]/a[5]/i")).click();
		chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Switch to new window opened
		String second_Window= null;
		for(String winHandle : chrome.getWindowHandles()){
			    
			if (winHandle!=mainWinHandle)
			{
				second_Window = winHandle;
				chrome.switchTo().window(second_Window);      
				//--Perform your operation here for new window
				//chrome.get("https://ekomi-connect-staging-1.ekomiapps.de/oauth/v2/auth/login");
				String title = chrome.getTitle();
				System.out.println(title);
				WebElement from = chrome.findElement(By.id("draggable_short_text"));
				WebElement to = chrome.findElement(By.xpath(".//*[@id='sortable']/li"));
				(new Actions(chrome)).dragAndDrop(from, to).perform();
				
			}
			
			if (winHandle!=mainWinHandle)
			{
				String third_Window = winHandle;
				chrome.switchTo().window(third_Window);
				chrome.findElement(By.xpath(".//*[@id='question_text']")).sendKeys("Short text");
				chrome.findElement(By.xpath(".//*[@id='multiple_choice_submit']")).click();
			
				chrome.switchTo().window(second_Window);	
				System.out.println("In forth window");
				chrome.findElement(By.id("save_changes_btn")).click();
				chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
			}
		}
	
  
}
}
