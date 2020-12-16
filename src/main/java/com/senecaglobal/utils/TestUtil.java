package com.senecaglobal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class TestUtil extends com.senecaglobal.baseTest.TestBase{
	
	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICITY_TIME = 10;
	
	
	public void switchToFrame() {
		
		driver.switchTo().frame("");
		
	}	
}

