package DealerAlarmTestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AlarmDealerCommandCatalogTestPage;

public class AlarmDealerCommandCatalogTest extends BaseClassAlarmTest {
	private static final Logger log = LogManager.getLogger(AlarmDealerCommandCatalogTest.class);

	
	@Test
	public void CommandCatalog() throws InterruptedException {
		System.out.println("Second Class");
		Thread.sleep(5000); // initial pause
		AlarmDealerCommandCatalogTestPage cmd = new AlarmDealerCommandCatalogTestPage(dri);
		cmd.commandCatalogLink(); // Step 1
		cmd.commandCatalogSearchBox(); // Step 2
		 try {
			    cmd.searchBluetooth(); // the step most likely to fail
			  } catch (Exception e) {
			    log.error("Command Catalog test failed", e);
			    throw e; // ensure TestNG marks it failed
			  }

	}
}
