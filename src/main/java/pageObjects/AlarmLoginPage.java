package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.WaitHelper;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlarmLoginPage extends BasePage{
	WebDriver driver;
	WaitHelper waitHelper;
	

	public AlarmLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver, 10); // 10s timeout
	
	}

	@FindBy(id="txtUsername")
	WebElement userNameInput;


	public void enterUsername(String username) {
	    waitHelper.waitForElementToBeVisible(userNameInput);
	    wait.until(ExpectedConditions.visibilityOf(userNameInput));
	    userNameInput.sendKeys(username);
	    log.info("Username entered: " + username);
	 //   wait.until(ExpectedConditions.visibilityOf(userNameInput));
	}

	@FindBy(id="txtPassword")
	WebElement passwordInput;

	public void enterPassword(String password) {
		waitHelper.waitForElementToBeVisible(passwordInput);
		wait.until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.clear();
		passwordInput.sendKeys(password);
		log.info("Password entered");
	}

	@FindBy(id = "butLogin")
	WebElement loginButton;

	public void clickLoginButton() {
		waitHelper.waitForElementToBeClickable(loginButton);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		log.info("Login button clicked");
	}

	@FindBy(id = "iconShowPassword")
	WebElement iconShowPassword;

	public void clickShowPassword() {
		waitHelper.waitForElementToBeClickable(iconShowPassword);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("iconShowPassword")));
		iconShowPassword.click();
		log.info("Show Password clicked");
	}

	@FindBy(id = "chkRememberMe")
	WebElement checkBox;

	public void clickRememberMeCheckbox() {
		waitHelper.waitForElementToBeClickable(checkBox);
		checkBox.click();
		log.info("Remember Me checkbox clicked");
	}

	@FindBy(xpath = "//*[@id='vsLogin' and contains(text(),'Please enter a password.')]")
	WebElement noPassword;

	public String getNoPasswordMessage() {
		waitHelper.waitForElementToBeVisible(noPassword);
		String msg = noPassword.getText();
		log.info("No password message: " + msg);
		return msg;
	}

	@FindBy(xpath = "//div[@id='vsLogin' and contains(text(),'Login failed')]")
	WebElement loginFailedText;

	public String getLoginFailedMessage() {
		waitHelper.waitForElementToBeVisible(loginFailedText);
		String msg = loginFailedText.getText();
		log.info("Login failed message: " + msg);
		return msg;
	}

	@FindBy(id = "HelpLink")
	WebElement forgotUsername;

	public String getForgotUsernameText() {
		waitHelper.waitForElementToBeVisible(forgotUsername);
		String msg = forgotUsername.getText();
		log.info("Forgot Username text: " + msg);
		return msg;
	}

	@FindBy(id = "lnkSSO")
	WebElement sso;

	public String getSSOText() {
		waitHelper.waitForElementToBeVisible(sso);
		String msg = sso.getText();
		log.info("SSO text: " + msg);
		return msg;
	}

	@FindBy(xpath = "//label[text()='Remember Me']")
	WebElement rememberMeText;

	public String getRememberMeLabel() {
		waitHelper.waitForElementToBeVisible(rememberMeText);
		String msg = rememberMeText.getText();
		log.info("Remember Me label: " + msg);
		return msg;
	}
}
