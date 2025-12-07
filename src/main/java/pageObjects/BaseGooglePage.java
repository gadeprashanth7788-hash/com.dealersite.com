package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BaseGooglePage {


	WebDriver dri;
	
	public BaseGooglePage(WebDriver dri) {
		
		PageFactory.initElements(dri, this);
	}
	
}