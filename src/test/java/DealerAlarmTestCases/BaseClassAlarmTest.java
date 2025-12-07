package DealerAlarmTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pageObjects.AlarmDealerCommandCatalogTestPage;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Listeners(listeners.ExtentReportListener.class)
public class BaseClassAlarmTest  {
	public static WebDriver dri;
    private static final Logger log = LogManager.getLogger(BaseClassAlarmTest.class);
    public static String username = "JCI-ADC-INDIA";
    public static String password = "QolsysJci$2025D1@";
    public static String deviceID = "JIQ5Panel_123";

	public static String expectedForgot = "Forgot Username or Password?";
	public static String expectedlnkSSO = "LOGIN WITH SSO";
	public static String expectedLoginFailedText = "Login failed: If your username was entered correctly and further action is needed, an email will be sent to the account on file with more details.";
	public static String expectedrememberMeTextActual = "Remember Me";
	public static String expectednoPassword = "Please enter a password.";

	
	 WebDriverWait wait;   

	    @BeforeSuite
	    public void setUp() throws InterruptedException {
	        dri = new ChromeDriver();
	        dri.manage().window().maximize();
	        dri.get("https://alarmadmin.alarm.com/");
	        Thread.sleep(10000);
	        wait = new WebDriverWait(dri, Duration.ofSeconds(10));  
	        log.info("Browser launched and navigated to Alarm.com");
	        
	    
	    }
	

	@AfterSuite
	public void tear() {
		
        if (dri != null) {
        	dri.quit();
   		 log.info("Browser closed");

        }
		
	}

}


/*	package Lucy.Gen4_Test_Base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_CustomerInfo_Page;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_Equipment;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_Home_Page;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_Login_Page;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_PowerG_Test_Base;
import Lucy.Dealer_Portal_ADC_Pages.Dealer_Portal_monitorSettings_Page;
import Lucy.TestUtils.AppiumBaseClass;
import Lucy.TestUtils.AppiumController;
import Lucy.TestUtils.Dealer_Portal_ADC_Utils;
import Lucy.TestUtils.User_Portal_ADC_Utils;
import Lucy.User_Portal_ADC_Pages.User_Portal_Home_Page;
import Lucy.User_Portal_ADC_Pages.User_Portal_Login_Page;
import Lucy.User_Portal_ADC_Pages.User_Portal_Users_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import powerManagePortalPages.PM_Firmware_Page;
import powerManagePortalPages.PM_State_Page;
import powerManagePortalPages.PowerManage_Configuration_Page;
import powerManagePortalPages.PowerManage_Devices_Page;
import powerManagePortalPages.PM_Configuration_Page;
import powerManagePortalPages.PM_Devices_Page;
import powerManagePortalPages.PM_Events_Page;
import powerManagePortalPages.PowerManage_Login_Page;
import powerManagePortalPages.PowerManage_State_Page;
import powerManagePortalPages.PowerManage_System_Tests_Page;

public class ADC_BaseTestClass extends AppiumBaseClass{
	
	public static WebDriver driver1;
	public static String profileName = "Default";
	public static ThreadLocal<WebDriver> Webdriver_Session = new ThreadLocal<WebDriver>();
	public static Dealer_Portal_Login_Page login;
	public static Dealer_Portal_Home_Page homepage;
	public static Dealer_Portal_Equipment equipmentPage;
	public static Dealer_Portal_CustomerInfo_Page customerinfo;
	public static Dealer_Portal_monitorSettings_Page monitorSettings;
	public static User_Portal_Login_Page user_login;
	public static User_Portal_Users_Page user_portal_users_page;
	public static String Url="https://alarmadmin.alarm.com/";
	public static User_Portal_Home_Page user_portal_home_page;
	public static Dealer_Portal_PowerG_Test_Base dealer_portal_test_base;
	public static Dealer_Portal_ADC_Utils DealerUtils;
	public static User_Portal_ADC_Utils UserUtils; 

	public static PowerManage_Login_Page PowerManageLoginPage;
	public static PowerManage_Devices_Page PowerManageDevicesPage;
	public static PowerManage_State_Page PowerManageStatePage;
	public static PowerManage_Configuration_Page PowerManageConfigurationPage;
	public static PowerManage_System_Tests_Page PowerManageSystemTestsPage;
	public static PM_Firmware_Page PMFirmwarePage;
	public static PM_State_Page PMStatePage;
	public static PM_Events_Page PMEventsPage;
	public static PM_Devices_Page PMDevicesPage;
	public static PM_Configuration_Page PMConfigurationPage;
	
	public static void SetUp(String Cloud) throws Exception{
		try {
		AppiumController.KillAllnode("Kill Chrome");
		if(prop.getProperty("BrowserName").contains("CHROME")) {
			
			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--disable-infobars");
			chromeOptions.addArguments("--window-size=1920,1080");
			chromeOptions.addArguments("--force-device-scale-factor=1");  // Disable scaling
			chromeOptions.addArguments("--ignore-certificate-errors");
			chromeOptions.addArguments("--allow-running-insecure-content");
			chromeOptions.addArguments("--remote-allow-origins=*");
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-gpu");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			
			if(Cloud.equalsIgnoreCase("adc")) {
				String userDataDir = System.getProperty("user.home")+ "\\AppData\\Local\\Google\\Chrome\\User Data\\"+profileName+"";
				System.err.println(userDataDir);
				chromeOptions.addArguments("--user-data-dir="+userDataDir);
				chromeOptions.addArguments("profile-directory=" + profileName);
				}
			
			WebDriverManager.chromedriver().setup();
			driver1 = new ChromeDriver(chromeOptions);
			
		}
		else if(prop.getProperty("BrowserName").contains("FIREFOX")) {

			WebDriverManager.firefoxdriver().setup();
			driver1 = new FirefoxDriver();
		}
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*		Webdriver_Session.set(driver1);
		Capabilities caps = ((RemoteWebDriver) driver1).getCapabilities();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName+" version "+browserVersion);
		driver1.manage().window().maximize();
		driver1.get(Url);
	
		Thread.sleep(5000);
		switch (Cloud) {
			case "ADC" :
				login = new Dealer_Portal_Login_Page(driver1);
				homepage = new Dealer_Portal_Home_Page(driver1);
				customerinfo = new Dealer_Portal_CustomerInfo_Page(driver1);
				monitorSettings = new Dealer_Portal_monitorSettings_Page(driver1);
				equipmentPage = new Dealer_Portal_Equipment(driver1);
				user_login = new User_Portal_Login_Page(driver1);
				user_portal_home_page=new User_Portal_Home_Page(driver1);
				user_portal_users_page=new User_Portal_Users_Page(driver1);
				dealer_portal_test_base=new Dealer_Portal_PowerG_Test_Base(driver1);
				DealerUtils = new Dealer_Portal_ADC_Utils(driver1);
				UserUtils = new User_Portal_ADC_Utils(driver1);
				
			break;
			
			case "PowerManage" :		
				PowerManageLoginPage = new PowerManage_Login_Page(driver1);			
				PowerManageDevicesPage = new PowerManage_Devices_Page(driver1);
				PowerManageStatePage = new PowerManage_State_Page(driver1);
				PowerManageConfigurationPage = new PowerManage_Configuration_Page(driver1);
				PowerManageSystemTestsPage = new PowerManage_System_Tests_Page(driver1);
				PMFirmwarePage = new PM_Firmware_Page(driver1);
				PMStatePage = new PM_State_Page(driver1);
				PMEventsPage = new PM_Events_Page(driver1);
				PMDevicesPage = new PM_Devices_Page(driver1);
				PMConfigurationPage = new PM_Configuration_Page(driver1); 
			break;
			}
		System.err.println(Cloud+" browser session is started");
		Login_To_Cloud_Platform(Cloud);
		
	}catch (Exception e) {
		e.printStackTrace();
		Webdriver_Session.get().quit();
		driver1.quit();
		AppiumController.KillAllnode("Kill Chrome");
		}
	}
	
	public static void Login_To_Cloud_Platform(String Cloud) throws Exception {
		try {
			switch(Cloud) {

			case "ADC" :
				login.Login_To_Dealer_Portal();	
				homepage.NavigateToParticularAccount(prop.getProperty("CustomerID"));
				break;

			case "PowerManage" :	
				PowerManage_Login_Page.Login_To_PowerMange_Portal();
				PowerManage_Devices_Page.Search_Account_With_Imei_And_Navigate_To_Account();
				break;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void imageCaptureDuringFailure(String screen_name) throws Exception {
		System.out.println("Image Capturing is in progress .......");
		Thread.sleep(1000);
		File screenshot = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		File screenshotLocation = new File(
				 System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + screen_name + ".png");
		FileUtils.copyFile(screenshot, screenshotLocation);
		System.out.println("Screenshot is captured in( " +screenshotLocation.toString() + ")!" );
	}
	
	public static void CloseDriver(String Cloud) throws Exception{
		try {
			String portalUrl=driver1.getCurrentUrl();

			switch(Cloud) {

			case "PowerManage" :
				PowerManage_Login_Page.Logout_To_PowerManage_Portal();
				break;

			case "ADC" :
				if(portalUrl.contains(Url)) {
					Dealer_Portal_Login_Page.Logout_From_Dealer_Portal();
				}else {
					User_Portal_Login_Page.Logout_From_User_Portal();
				}	
				break;
			}
			Thread.sleep(5000);
			driver1.quit();
			AppiumController.KillAllnode("Kill Chrome");
			Thread.sleep(2000);

		}catch (Exception e) {
			e.printStackTrace();
			driver1.quit();
			AppiumController.KillAllnode("Kill Chrome");
		}
	}


}*/
