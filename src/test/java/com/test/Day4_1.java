package com.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.TestNG_5;


import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Day4_1 {
	WebDriver driver = TestNG_5.getDriver("chrome");
	 ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\Training_B6b.01.16\\Desktop\\abc.html");
	 ExtentReports extent = new ExtentReports();
	 ExtentTest logger = extent.createTest("TestMeApp");
	
  @Test(priority=3,enabled=true)
  public void testCart() throws InterruptedException {
	  Actions act1 = new Actions(driver);
	  act1.moveToElement(driver.findElement(By.linkText("All Categories"))).click().perform();
	  Thread.sleep(5000);
	  act1.moveToElement(driver.findElement(By.linkText("Electronics"))).click().build().perform();
	  Thread.sleep(5000);
	  act1.moveToElement(driver.findElement(By.xpath("//span[@onclick='getProducts(11290,112101)']"))).click().build().perform();
	  driver.findElement(By.xpath("//a[@href='#'][@class='btn btn-success btn-product']")).click();
	  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	  driver.findElement(By.xpath("//input[@type='submit'][@value='Proceed to Pay']")).click();
	  
  }
  
  
  @Test(priority=2,enabled=true)
  public void testLogin() {
	  driver.findElement(By.name("userName")).sendKeys("Lalitha");
	  driver.findElement(By.name("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
  }
  
  
  @Test(priority=4,enabled=true)
  public void testPayment() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[1]/div[5]/div")).click();
	  driver.findElement(By.id("btn")).click();
	  driver.findElement(By.name("username")).sendKeys("123458");
	  driver.findElement(By.name("password")).sendKeys("Pass@458");
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@458");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
  }
  
  
  @Test(priority=1,enabled=true)
  public void testRegistration() {
	  driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
	  driver.findElement(By.name("userName")).sendKeys("JaideepSingh");
	  driver.findElement(By.name("firstName")).sendKeys("Jaideep");
	  driver.findElement(By.name("lastName")).sendKeys("Singh");
	  driver.findElement(By.id("password")).sendKeys("LolPol69!");
	  driver.findElement(By.name("confirmPassword")).sendKeys("LolPol69!");
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/input[1]")).click();
	  driver.findElement(By.name("emailAddress")).sendKeys("jaideepwalia@rocketmail.com");
	  driver.findElement(By.name("mobileNumber")).sendKeys("8217572469");
	  driver.findElement(By.name("dob")).sendKeys("03/07/1997");
	  driver.findElement(By.id("address")).sendKeys("106 East, Trinity Acres and Woods Bangalore");
	  Select pc = new Select(driver.findElement(By.id("securityQuestion")));
	  pc.selectByIndex(2);
	  driver.findElement(By.name("answer")).sendKeys("Lyra");
	  driver.findElement(By.name("Submit")).click();
  }
  
  
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	  extent.attachReporter(reporter);
	 
	  if (result.getStatus() == ITestResult.SUCCESS) {
		  logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		  TakesScreenshot snapshot=(TakesScreenshot)driver;
		  File src = snapshot.getScreenshotAs(OutputType.FILE);
		  String path = System.getProperty("user.dir") + "/extent-reports/snapshots/"+result.getName()+".png";
		  FileUtils.copyFile(src, new File(path));
		  logger.addScreenCaptureFromPath(path, result.getName());
		 // logger.log(Status.PASS, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Passed", ExtentColor.GREEN));
	  }
	  else if (result.getStatus() == ITestResult.SKIP) {
		  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	  }
	  extent.flush();
  }
  
  
  
  @AfterTest
  public void endReportAfterTest() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	  Thread.sleep(5000);
	  driver.close();
  }
  
  
  @BeforeTest
  public void startReportBeforeTest() {
	  
	  driver.manage().window().maximize();
	  String url = "http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	  driver.get(url);
  }
 
}
