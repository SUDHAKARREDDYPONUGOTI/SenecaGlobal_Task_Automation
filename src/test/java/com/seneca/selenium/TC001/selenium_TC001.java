package com.seneca.selenium.TC001;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.senecaglobal.baseTest.TestBase;


public class selenium_TC001 extends TestBase {
	
	TestBase mainclass;
	
//	public selenium_TC001(){
//		super();
//	}
	
	
	@Test(priority = 1)
	public void GoogleTC001() {
		
		System.out.println("Test");		
		initialize();
		
		
		WebElement clickLuck = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='RNmpXc' and @value]"));
		clickLuck.click();
		
		driver.findElement(By.xpath("//li[@id='latest-nav-0']")).click();
		WebElement clicktab1 = driver.findElement(By.xpath("//div[@class='title']/a[@id='latest-title']"));
		System.out.println("Read the textof the First Doodle is --> " + clicktab1.getText());
	
		System.out.println("==================================================");
	
	}
	
	@Test(priority = 2)
	public void readDoodle() {
		
//		WebElement clickonDoodleArchive = driver.findElement(By.xpath("//li[@id='archive-link']/a"));
//		clickonDoodleArchive.click();
				
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		listLinks.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total links and images in the Page --->" + listLinks.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i < listLinks.size(); i ++) {
			
			System.out.println(listLinks.get(i).getAttribute("href"));
			
			if (listLinks.get(i).getAttribute("href") != null) {
				
				activeLinks.add(listLinks.get(i));	
				
				System.out.println("Total active links and images are --->" + activeLinks.size());
				
				//String alllinks = activeLinks.get(0).getText();
				// System.out.println("All the linksdata is -->  " + alllinks);
				
			}
		}

	}
}
