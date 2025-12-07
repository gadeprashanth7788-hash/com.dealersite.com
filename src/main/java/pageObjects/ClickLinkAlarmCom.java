package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClickLinkAlarmCom extends BaseGooglePage{

	public ClickLinkAlarmCom(WebDriver dri) {
		super(dri);
	}
	
	@FindBy(xpath="(//*[contains(text(), 'Alarm.com | Best Smart Security Alarm & Monitoring Systems')])[1]")
	WebElement linkClick;
	
	public void clickLink() {
		linkClick.click();
	}

}
