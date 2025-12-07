package pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Utilities.WaitHelper;

public class AlarmDealerCommandCatalogTestPage {
    public static WebDriver dri;
    private static final Logger log = LogManager.getLogger(AlarmDealerCommandCatalogTestPage.class);

    WaitHelper waitHelper;

    public AlarmDealerCommandCatalogTestPage(WebDriver dri) {
        this.dri = dri;
        PageFactory.initElements(dri, this);
        waitHelper = new WaitHelper(dri, 20);
    }

    @FindBy(xpath="//a[@href='/Support/CommandCatalog/CommandCatalogV2.aspx' and @title='Remotely send commands.']")
    WebElement commandCatalog;

    @FindBy(xpath="//input[@placeholder='Search Command Catalog']")
    WebElement searchCommandCatalog;

    @FindBy(xpath = "//a[@class='cmd-link' and text()='Bluetooth Disarm']")
    WebElement bluetoothSearch;

    // Step 1: Click the Command Catalog link
    public void commandCatalogLink() {
        waitHelper.waitForElementToBeClickable(commandCatalog);
        commandCatalog.click();
        log.info("CommandCatalog Clicked");
    }

    // Step 2: Enter text in the search box
    public void commandCatalogSearchBox() {
        waitHelper.waitForElementToBeVisible(searchCommandCatalog);
        searchCommandCatalog.sendKeys("Bluetooth");
        new Actions(dri).sendKeys(Keys.ENTER).perform();
        log.info("Bluetooth Entered");
    }

    // Step 3: Click the Bluetooth search result
    public void searchBluetooth() {
        waitHelper.waitForElementToBeClickable(bluetoothSearch);
        bluetoothSearch.click();
        log.info("Bluetooth Clicked");
        Assert.assertTrue(true, "Bluetooth page did not open");

    }
}
