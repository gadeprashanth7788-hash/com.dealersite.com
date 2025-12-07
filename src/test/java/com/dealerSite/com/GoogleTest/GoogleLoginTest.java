package com.dealerSite.com.GoogleTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pageObjects.ClickLinkAlarmCom;
import pageObjects.GooglePage;

public class GoogleLoginTest extends BaseClassGoogleTest {
	
	@Test
	public void googleSearch() throws Throwable {
		GooglePage gp = new GooglePage(dri);
		gp.searchButton();
		Thread.sleep(10000);
		Actions act = new Actions(dri);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(40000);
	}

	@Test(priority = 2)
	public void clickLinkAlarm(){
		ClickLinkAlarmCom cl = new ClickLinkAlarmCom(dri);
		cl.clickLink();
	}
}
