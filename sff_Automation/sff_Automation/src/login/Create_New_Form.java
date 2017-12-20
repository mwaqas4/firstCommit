package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class Create_New_Form {

@Test
public void create_new_form() {
	
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
    options.addArguments("--start-minimized");
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

	chrome.get(prop.getProperty("URL_staging"));
	chrome.findElement(By.id("shop_id")).sendKeys(prop.getProperty("shop"));
	chrome.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button")).click();         
	chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	String pagetitle = chrome.getTitle();
	System.out.println("Page titel is " + pagetitle);
	 
	chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
	chrome.getCurrentUrl();
	
	String winHandleBefore = chrome.getWindowHandle();
	chrome.findElement(By.xpath("/html/body/section/div/div/div/div/button[1]")).click();
	chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	// Switch to new window opened
	for(String winHandle : chrome.getWindowHandles()){
		    
		if (winHandle!=winHandleBefore)
		{
			      
			String second_Window = winHandle;
			chrome.switchTo().window(second_Window);
			      
			//--Perform your operation here for new window
			//chrome.get("https://ekomi-connect-staging-1.ekomiapps.de/oauth/v2/auth/login");
			String title = chrome.getTitle();
				     
			System.out.println(title);
			
			chrome.findElement(By.id("survey_name")).sendKeys(prop.getProperty("new_form_name"));
			 
			Select default_Language = new Select(chrome.findElement(By.id("form_default_language")));
			default_Language.selectByVisibleText("Spanish");
					 
			Select review_Type = new Select(chrome.findElement(By.id("review_type")));
			review_Type.selectByValue("product");
			
			chrome.findElement(By.id("survey_submit_button")).click();
			System.out.println("after save button click");
			chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					 
		}
	
		if(winHandle!=winHandleBefore)
		{
			String third_Window = winHandle;
			chrome.switchTo().window(third_Window);	
			System.out.println("In third window");
			chrome.findElement(By.id("choose-survey-btn")).click();
			
			
		}
		
		if(winHandle!=winHandleBefore)
		{
			String forth_Window = winHandle;
			chrome.switchTo().window(forth_Window);	
			System.out.println("In forth window");
			chrome.findElement(By.id("save_changes_btn")).click();
			chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			chrome.findElement(By.xpath(".//*[@id='save_changes_form']/div[1]/div/div[2]/a[1]")).click();
		
		}
	}
		 
	        		 
	chrome.switchTo().window(winHandleBefore);
	System.out.println("Test case passed");        		
	        		

}
 
}
