package com.autotech.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.autotech.base.TestBase;
import com.autotech.utilities.SnapShot;

import jdk.internal.jline.internal.Log;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException, IOException, AWTException {
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.cssSelector(or.getProperty("bankManagerLoginBtn"))).click();
		Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustomerButton"))));
		appLog.debug("Logged into application successfully");
		Reporter.log("Logged into application successfully");
//		String loginAsBankManagerDateTimeVar = dateFormat.format(new Date());
//		SnapShot.takesSnapShot(driver, System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\loginAsBankManager_"+loginAsBankManagerDateTimeVar+".png");	
//		Reporter.log("<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\loginAsBankManager_"+loginAsBankManagerDateTimeVar+".png\">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\loginAsBankManager_"+loginAsBankManagerDateTimeVar+".png\"><img src=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\loginAsBankManager_"+loginAsBankManagerDateTimeVar+".png\" height=200 width=200></img></a>");
		
		driver.findElement(By.cssSelector(or.getProperty("addCustomerButton"))).click();
	//	Assert.fail("Login not successful");
	}
}
