package com.bruteforce.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;




public class fahimTest {
	
	WebDriver driver;
	
	
  @Test (priority = 1, enabled=false)
  public void invalidEmail() {
	  
	  driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='email_create']")).click();
	  driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys("invalidEmail@email");
	  driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
	  
	  String color = driver.findElement(By.xpath(".//*[@id='email_create']")).getCssValue("background-color");
	  System.out.println(color);
	  
  }
  
  @Test (priority = 2, enabled=false)
  public void existingEmail() {
	  
	  driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='email_create']")).click();
	  driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys("rabbani@rabbani.com");
	  driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
	  
	  String expectedResult = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
	  String actualResult = driver.findElement(By.xpath(".//*[@id='create_account_error']/ol/li")).getText();
	 
	  if(actualResult.equals(expectedResult)){
		  
		  System.out.println("Passed");
	  }
	  else{
	  System.out.println("failed");
	  }
  }
  
  @Test (priority = 3, enabled = true)
  public void createNewAccount() {
	  
	  driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	// random string of length 8 composed of alphabetic characters 
	//	  String firstName = RandomStringUtils.randomAlphabetic(7); 
	//  String lastName = RandomStringUtils.randomAlphanumeric(6); 
	  
	  String alphabet = "abcdefghijklmnopqrstuvwxyz";
	  String firstName = RandomStringUtils.random(8, alphabet);
	  String lastName = RandomStringUtils.random(8, alphabet);

	  System.out.println(firstName);
	  System.out.println(lastName);
	  
	  String email = firstName+lastName+"@yahoo.com";
	  System.out.println(email);
	  
	  driver.findElement(By.xpath(".//*[@id='email_create']")).click();
	  driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys(email);
	  driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='account-creation_form']/div[1]/div[1]/div[1]/label")).click();
	  driver.findElement(By.xpath(".//*[@id='customer_firstname']")).sendKeys(firstName);
	  driver.findElement(By.xpath(".//*[@id='customer_lastname']")).sendKeys(lastName);
	  //driver.findElement(By.xpath(".//*[@id='email']"));
	  driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("fahim1985");
	  driver.findElement(By.xpath(".//*[@id='days']")).sendKeys("7");
	  driver.findElement(By.xpath(".//*[@id='months']")).sendKeys("April");
	  driver.findElement(By.xpath(".//*[@id='years']")).sendKeys("1990");
	  driver.findElement(By.xpath(".//*[@id='submitAccount']")).click();
	  
	  String name = firstName+" "+lastName;
	  System.out.println(name);
	  
  }
  
  
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	 System.setProperty("webdriver.chrome.driver", "./util/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://ebfs.bruteforcesolution.net/ebfs/");
  }

  @AfterMethod
  public void afterMethod() {
	//  driver.close();
	  
  }

}
