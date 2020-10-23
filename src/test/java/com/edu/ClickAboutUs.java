package com.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ClickAboutUs {
	
  WebDriver driver;
 
  @BeforeMethod
  public void launch() {
	  
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://35.202.36.235:9000/");
  }
  
  @Test
  public void verifyUrl() {
	  
	    String url = driver.getCurrentUrl();
	    System.out.println(url);
  }
  
  @Test
  public void verifyHeader() {
	  
        String header = driver.getTitle();
        System.out.println(header);
        Assert.assertEquals(header, "Home | Simple PHP Website");
  }
  

  
  @Test
  public void findElement() throws Exception{
	 
	    driver.findElement(By.linkText("About Us")).click();
	    List<WebElement> downloadBody = driver.findElements(By.xpath("//body[contains(text(), 'about')]"));
	    if(downloadBody.size() > 0)
	    {
	        System.out.println("Found body element [[about]]");
	    }
  }
 
  
  @AfterMethod
  public void afterMethod() {  
	  driver.close();
  }

}
