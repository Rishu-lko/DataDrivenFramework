package com.autotech.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autotech.base.TestBase;
import com.autotech.utilities.SnapShot;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText)
			throws InterruptedException, IOException, AWTException {
		// System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(or.getProperty("addCust"))).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(alertText));
		TimeUnit.SECONDS.sleep(1);
		Reporter.log("Customer added successfully");
//		String addCustomerTimeVar = dateFormat.format(new Date());
//		SnapShot.takesSnapShot(driver, System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\addCustomer_"+addCustomerTimeVar+".png");	
//		Reporter.log("<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\addCustomer_"+addCustomerTimeVar+".png\">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\addCustomer_"+addCustomerTimeVar+".png\"><img src=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\addCustomer_"+addCustomerTimeVar+".png\" height=200 width=200></img></a>");
		// TimeUnit.SECONDS.sleep(3);
		alert.accept();
		// Assert.fail("Add customer not successful");

	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows][cols];

		for (int rownum = 1; rownum <= rows; rownum++) {
			for (int colnum = 1; colnum <= cols; colnum++) {
				if (colnum != 3) {
					data[rownum - 1][colnum - 1] = excel.getStringCellData(sheetName, rownum, colnum);
				} else {
					data[rownum - 1][colnum - 1] = String.valueOf(excel.getNumericCellData(sheetName, rownum, colnum));
				}
			}
		}

		return data;

	}

}
