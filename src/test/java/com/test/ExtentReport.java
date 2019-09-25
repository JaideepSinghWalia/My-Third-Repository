package com.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
  @Test
  public void f() {
	  ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\training_b6b.01.16\\Desktop\\abc.html");
		 ExtentReports extent = new ExtentReports();
		 ExtentTest logger = extent.createTest("TestMeApp");
		 System.out.println("After Method is being executed");
		  extent.attachReporter(reporter);
		  logger.log(Status.INFO, "The TestMeApp EndToEnd functionality is checked with Selenium");
		  logger.log(Status.PASS, "The Test Cases were executed successfully!");
		  logger.log(Status.PASS, MarkupHelper.createLabel("Execution was completed as expected", ExtentColor.GREEN));
  }
}
