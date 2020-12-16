package com.senecaglobal.baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.senecaglobal.utils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;

	public static Properties prop;
	public  static EventFiringWebDriver e_driver;

	
	

	/* @author *** Sudhakar Ponugoti ******/
	
	
	public TestBase() {

		try {
			prop = new Properties();

			FileInputStream fip = new FileInputStream("src\\main\\java\\com\\sanacaglobal\\config\\config.properties");

			prop.load(fip);

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {

		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", 
					"Browsers\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if (browser.equals("FF")) {
			
			System.setProperty("webdriver.chrome.driver", 
					"Test");
			 driver = new FirefoxDriver();

		}else if (browser.equals("IE")) {
			
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\sponugoti\\workspace\\POM-FreeCrm\\Browsers\\chromedriver.exe");
			 driver = new InternetExplorerDriver();
		}
			
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}
}
