package com.dealerSite.com.GoogleTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassGoogleTest {
	
	public WebDriver dri;
	
	@BeforeClass
	public void setUp() {
		dri = new ChromeDriver();
		dri.get("https://www.google.com/");
		dri.manage().window().maximize();
	}
	
	@AfterClass
	public void tear() {
		dri.quit();
	}

}
