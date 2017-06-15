package com.bruteforce.test;

import org.testng.annotations.Test;

import com.bruteforce.HomePage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;



public class fahimTest {
	HomePage objHomePage;
	
	WebDriver driver;
	
	WebElement message, name01, name02;
	
	
  @Test (priority = 1, enabled=false)
  public void invalidEmail() {
	  
	  //driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  
	  objHomePage = new HomePage(driver);
	  objHomePage.clickSignInLink();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='email_create']")).click();
	  driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys("invalidEmail@email");
	  driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
	  
	  String color = driver.findElement(By.xpath(".//*[@id='email_create']")).getCssValue("background-color");
	  System.out.println(color);
	  
  }
  
  @Test (priority = 2, enabled=false)
  public void existingEmail() {
	  
	  //driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  
	  objHomePage = new HomePage(driver);
	  objHomePage.clickSignInLink();
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
  
  @Test (priority = 3, enabled = false)
  public void createNewAccount() {
	  
	  //driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  objHomePage = new HomePage(driver);
	  objHomePage.clickSignInLink();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  //used random key
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
	  
	  //String name = firstName+" "+lastName;
	  //System.out.println(name);
	  
	  
	  
	  String message = driver.findElement(By.xpath(".//*[@id='center_column']/p[1]")).getText();
	  String message02 = "Your account has been created.";
	 
	  System.out.println(message);
	  
	  if (message.equalsIgnoreCase(message02)){
		  
	  
	  System.out.println("passed");
  }
	  else{
		  
	  System.out.println("failed");  
	  }
	  
	  
	  //validate first & last name
	  String fullName = driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText();
	  String name = firstName+" "+lastName;
	  System.out.println(name);
	  
	  //click personal info link
	  driver.findElement(By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[5]/a/span")).click();
	  
	  //update last name 
	  driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("khan");
	  
	  
	  //type current pass
	  driver.findElement(By.xpath(".//*[@id='old_passwd']")).sendKeys("fahim1985");
	  
	  //click save button
	  driver.findElement(By.xpath(".//*[@id='center_column']/div/form/fieldset/div[11]/button")).click();
	  
	  
	  //Validate last name
	  String lastname = driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a/span")).getText();
	  String lastname02 = name+"khan";
      System.out.println(lastname);
      
	  if (lastname.equalsIgnoreCase(lastname02)){
		  
	  
	  System.out.println("passed");
	  
	  }
	  
      
	  else{
		  System.out.println("failed");
	  }
	  
	  
	  
  }
  
  
  
  
  @Test (priority = 4, enabled = false)
  public void productsearch() {
	  
	  //driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
	  objHomePage = new HomePage(driver);
	  objHomePage.clickSignInLink();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='search_query_top']")).sendKeys("Shirt");
	  driver.findElement(By.xpath(".//*[@id='searchbox']/button")).click();
	  
	  String Seller = driver.findElement(By.xpath(".//*[@id='best-sellers_block_right']/h4/a")).getText();
	  String Seller2 = "TOP SELLERS";
	  
      System.out.println(Seller);
	  
	  if (Seller.equalsIgnoreCase(Seller2)){
		  
	  
	  System.out.println("passed");
  }
	  else{
		  
	  System.out.println("failed"); 
	  
	  }
	  
	  
  }
  
  
  
  @Test(priority = 5, enabled = true)
  public void CartValidation(){
	  
	  
	  
	  //driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a")).click();
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  WebElement element = driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img"));
	  //WebElement quickview = driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[2]"));
	
	 
	  //Actions action = new Actions(driver);
	 // action.moveToElement(dresses).build().perform();
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 // driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[2]")).click();
	  
	  
	  
	  //WebElement element = driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]"));
       //WebDriverWait wait = new WebDriverWait(driver, 30);
         //wait.until(ExpectedConditions.visibilityOf(element));
         Actions action = new Actions (driver);
         action.moveToElement(element).click().build().perform();
         //driver.findElement(By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[2]")).click();
	  
         
         
         driver.findElement(By.xpath(".//*[@id='quantity_wanted_p']/a[2]/span")).click();  
         
         driver.findElement(By.xpath(".//*[@id='group_1']"));
         driver.findElement(By.xpath(".//*[@id='group_1']"));
         
         
         
  }
	  
	  
  
 

  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	 String BrowserName = "Chrome";
	 
	 if (BrowserName.equals("Chrome")){
		  
	  System.setProperty("webdriver.chrome.driver", "./util/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://ebfs.bruteforcesolution.net/ebfs/");
  }
	 else if(BrowserName.equalsIgnoreCase("gecko")){
	  System.setProperty("webdriver.gecko.driver", "./util/geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/");
	  
  }
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.close();
	  
  }

}
