package login;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class login extends configuration{
	@Test (priority=1)
  public void invalid_shop() {
	  
	 
	 // System.setProperty("webdriver.opera.driver", "F:\\selenium\\operadriver.exe");
	 // WebDriver driver = new FirefoxDriver();
	 // WebDriver opera = new OperaDriver();
	browser();
	WebDriver chrome = new ChromeDriver();
	
	 chrome.get("https://sff.coeus-solutions.de/user/login");
	 WebElement id = chrome.findElement(By.id("shop_id"));
	 id.sendKeys("6657");
	 WebElement pass = chrome.findElement(By.name("password"));
	 pass.sendKeys("FMJuyuC8uEbo3WxRa5aG");
	 WebElement button = chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button"));         
	 button.submit();
	 chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
     String actual_msg=chrome.findElement(By.xpath("html/body/section/div/div/div/div/div[2]/div")).getText();
	 
	// WebElement errorMessage = chrome.findElement(By.xpath(".//*[@class='login-body']/p[@class='alert alert-danger']"));
	   // String innerHTML = errorMessage.getText();
	  //  System.out.println(innerHTML);
	  //  System.out.println(errorMessage.getText());
	 //   Assert.assertEquals(actual_msg, "Shop is not recognized by ekomi.");
	    
     System.out.println(actual_msg);
     AssertJUnit.assertEquals(actual_msg,"Shop is not recognized by ekomi.");
	
	 
  }
 // @Test (priority=2)
  public void invalid_password() {
	  
	 
	 // System.setProperty("webdriver.opera.driver", "F:\\selenium\\operadriver.exe");
	//  WebDriver driver = new FirefoxDriver();
	 // WebDriver opera = new OperaDriver();
	browser();
	WebDriver chrome = new ChromeDriver();
	
	 chrome.get("https://sff.coeus-solutions.de/user/login");
	 WebElement id = chrome.findElement(By.id("shop_id"));
	 id.sendKeys("665");
	 WebElement pass = chrome.findElement(By.name("password"));
	 pass.sendKeys("FMJuyuC8uEbo3WxRa5aGdf");
	 WebElement button = chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button"));         
	 button.submit();
	 chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
     String actual_msg=chrome.findElement(By.xpath("html/body/section/div/div/div/div/div[2]/div")).getText();
	 
	// WebElement errorMessage = chrome.findElement(By.xpath(".//*[@class='login-body']/p[@class='alert alert-danger']"));
	   // String innerHTML = errorMessage.getText();
	  //  System.out.println(innerHTML);
	  //  System.out.println(errorMessage.getText());
	   // Assert.assertEquals(actual_msg, "Shop is not recognized by ekomi.");
	
     System.out.println(actual_msg);
     AssertJUnit.assertEquals(actual_msg,"Invalid ID or Password, Please try again using your valid credentials.");
	
	 
  }
  
 // @Test (priority=3)
  public void empty_credentials() {
	  
	 
	 // System.setProperty("webdriver.opera.driver", "F:\\selenium\\operadriver.exe");
	  /*WebDriver driver = new FirefoxDriver();*/
	 // WebDriver opera = new OperaDriver();
	browser();
	WebDriver chrome = new ChromeDriver();
	
	 chrome.get("https://sff.coeus-solutions.de/user/login");
	 WebElement id = chrome.findElement(By.id("shop_id"));
	 id.sendKeys("");
	 WebElement pass = chrome.findElement(By.name("password"));
	 pass.sendKeys("");
	 WebElement button = chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button"));         
	 button.submit();
	 chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
     String shop_msg=chrome.findElement(By.xpath("html/body/section/div/div/div/div/div[2]/form/div[3]/div/span")).getText();
     String password_msg=chrome.findElement(By.xpath("html/body/section/div/div/div/div/div[2]/form/div[4]/div/span")).getText();
	 String shop_error_msg= "User Shop id is Required.";
	 String pass_error_msg="Password is required.";
	// WebElement errorMessage = chrome.findElement(By.xpath(".//*[@class='login-body']/p[@class='alert alert-danger']"));
	   // String innerHTML = errorMessage.getText();
	  //  System.out.println(innerHTML);
	  //  System.out.println(errorMessage.getText());
	    /*Assert.assertEquals(actual_msg, "Shop is not recognized by ekomi.");
	     * */
     System.out.println(shop_msg);
     System.out.println(password_msg);
     if (shop_msg.equals(shop_error_msg)&&(password_msg.equals(pass_error_msg)))
 	{
 	System.out.println( "Test Passed") ;
 	}
 	else {
 	System.out.println( "Test Failed" );
 	}
    // Assert.assertEquals(shop_msg,"User Shop id is Required.");
  //   Assert.assertEquals(password_msg,"Password is required.");
	
	 
  }
  
  //@Test (priority=4)
  public void valid_case() {
	  
	 
	 // System.setProperty("webdriver.opera.driver", "F:\\selenium\\operadriver.exe");
	 // WebDriver driver = new FirefoxDriver();
	 // WebDriver opera = new OperaDriver();
		browser();
		WebDriver chrome = new ChromeDriver();
	
	 chrome.get("https://sff.coeus-solutions.de/user/login");
	 WebElement id = chrome.findElement(By.id("shop_id"));
	 id.sendKeys("665");
	 WebElement pass = chrome.findElement(By.name("password"));
	 pass.sendKeys("FMJuyuC8uEbo3WxRa5aG");
	 WebElement button = chrome.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[5]/div/button"));         
	 button.submit();
	 String pagetitle = chrome.getTitle();
	 System.out.println("Page titel is " + pagetitle);
	 
	 chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 String URL = chrome.getCurrentUrl();
	 
	if(URL.equalsIgnoreCase("https://sff.coeus-solutions.de/home"))
	   System.out.println("test passed");
	else
		System.out.println("test failed");
	 
  }}
  