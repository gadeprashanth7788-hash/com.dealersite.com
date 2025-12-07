package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BaseGooglePage {

	public GooglePage(WebDriver dri) {
		super(dri);
	}
	
	@FindBy(xpath="//textarea[@class='gLFyf' and @rows='1']")
	WebElement SearchField;
	
	
	public void searchButton() {
		SearchField.sendKeys("Alarm.com");
		
		
	}

}
