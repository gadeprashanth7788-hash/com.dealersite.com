package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.WaitHelper;

public class Enable_DisableBluetoothPage {
	
	public static WebDriver dri;
	WaitHelper waitHelper;
	WebDriverWait wa = new WebDriverWait(dri, Duration.ofSeconds(10));
	
	
	public Enable_DisableBluetoothPage(WebDriver dri) {
		this.dri=dri;
		PageFactory.initElements(dri , this);
	}
	
	
	

}
