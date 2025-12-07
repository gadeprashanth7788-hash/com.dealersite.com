package pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
@Listeners(listeners.ExtentReportListener.class)
public class BasePage {
	
	public static WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Logger log = LogManager.getLogger(BasePage.class);
	Logger logs = LogManager.getLogger();
	
}
