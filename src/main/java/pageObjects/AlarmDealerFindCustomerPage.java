package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.WaitHelper;

import org.apache.logging.log4j.LogManager;

public class AlarmDealerFindCustomerPage {

	public static WebDriver dri;
	WaitHelper waitHelper;

    public static final Logger log = LogManager.getLogger(AlarmLoginPage.class);

    public AlarmDealerFindCustomerPage(WebDriver driver) {
    	this.dri=driver;
    	PageFactory.initElements(dri, this);
		waitHelper = new WaitHelper(dri, 10); // 10s timeout

    }
    
    @FindBy(id="ctl00_customerSearch")
    WebElement FindCustomerSearchBar;
  
    public void findCustomerSearch(String DeviceID) {
    	FindCustomerSearchBar.sendKeys(DeviceID);
    }
    
    @FindBy(xpath = "//label[normalize-space(text())='Login Name']")
    WebElement loginName;
    
    public void customerLoginName() {
    	loginName.click();
    	log.info("login Clicked");
    }
    
    @FindBy(xpath = "//div[contains(text(),'customer was changed')]")
    WebElement selectedCustomerText;
    
    public void SelectedCustomer() {
    	if(selectedCustomerText.isDisplayed()) {
    		log.info("Customer Selected");
    	}
    }
    
	@FindBy(id="txtUsername")
	WebElement userNameInput;

	public void enterUsername(String username) {
		waitHelper.waitForElementToBeVisible(userNameInput);
		userNameInput.sendKeys(username);
		log.info("Username entered: " + username);
	}
    
	@FindBy(id = "txtPassword")
	WebElement passwordInput;

	public void enterPassword(String password) {
		waitHelper.waitForElementToBeVisible(passwordInput);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		log.info("Password entered");
	}
    
	@FindBy(id = "butLogin")
	WebElement loginButton;

	public void clickLoginButton() {
		waitHelper.waitForElementToBeClickable(loginButton);
		loginButton.click();
		log.info("Login button clicked");
	}
    
    
    
    
    
    
}
