package DealerAlarmTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AlarmDealerCommandCatalogTestPage;
import pageObjects.AlarmDealerFindCustomerPage;


@Listeners(listeners.ExtentReportListener.class)
public class AlarmDealerFindCustomerTest extends BaseClassAlarmTest {

	private static final Logger log = LogManager.getLogger(AlarmComLoginTest.class);

	
	@Test
	
	public void FindCustomer() throws Throwable {
		System.out.println("sssssssp");
		AlarmDealerFindCustomerPage custFind = new AlarmDealerFindCustomerPage(dri);
		custFind.enterUsername(username);
		custFind.enterPassword(password);
		custFind.clickLoginButton();
		custFind.findCustomerSearch(deviceID);
		custFind.customerLoginName();
		custFind.SelectedCustomer();
	}


}
