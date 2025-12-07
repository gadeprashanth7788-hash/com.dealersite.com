package com.Utilities;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	public class WaitHelper {
	    private WebDriver driver;
	    private WebDriverWait wait;

	    public WaitHelper(WebDriver driver, int timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    public void waitForElementToBeVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementToBeClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void waitForTextToBePresent(WebElement element, String text) {
	        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	    }
	
	
}
