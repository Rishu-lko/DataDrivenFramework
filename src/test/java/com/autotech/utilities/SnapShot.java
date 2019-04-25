package com.autotech.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.autotech.base.TestBase;

public class SnapShot extends TestBase{

	public static void takesSnapShot(WebDriver driver,String fileWithPath) throws IOException, AWTException {
		try {
		TakesScreenshot srcShot = (TakesScreenshot)driver;
		File srcFile=srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(fileWithPath);
		 FileUtils.copyFile(srcFile, destFile);
		}
		catch(Exception e) {
			Robot robot = new Robot();
			// create rectangle for full screenshot
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			// capture screen of the desktop
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
			// save the screenshot to local system
			ImageIO.write(screenFullImage, "jpg", new File(fileWithPath));
		}
		
	}
	
}
