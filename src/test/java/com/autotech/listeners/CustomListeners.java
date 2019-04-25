package com.autotech.listeners;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.autotech.base.TestBase;
import com.autotech.utilities.SnapShot;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestFailure(ITestResult args) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			String timeVar = dateFormat.format(new Date());
			SnapShot.takesSnapShot(driver, System.getProperty("user.dir")
					+ "\\src\\test\\resources\\screenshots\\errorScreenshot_" + timeVar + ".jpg");
			Reporter.log("<a target=\"_blank\" href=\"" + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\screenshots\\errorScreenshot_" + timeVar + ".jpg\">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<a target=\"_blank\" href=\"" + System.getProperty("user.dir")
					+ "\\src\\test\\resources\\screenshots\\errorScreenshot_" + timeVar + ".jpg\"><img src=\""
					+ System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\errorScreenshot_" + timeVar
					+ ".jpg\" height=200 width=200></img></a>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Unable to capture error screenshot");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Unable to capture error screenshot");
		}
	}

}
