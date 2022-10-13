package Tests;

import Browsers.Browser;
import Browsers.BrowserFactory;
import Browsers.BrowserHelpers;
import POM.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    public BrowserHelpers BrowserHelpers;
    public LandingPage LandingPage;

    public WebDriver Driver;

    @BeforeSuite
    public void Setup() throws Exception {
        BrowserFactory browserFactory = new BrowserFactory();

        Driver = browserFactory.GetDriver(Browser.Chrome);
        BrowserHelpers = new BrowserHelpers(Driver);
    }

    @BeforeTest
    public void TestSetup() throws InterruptedException {
        LandingPage = new LandingPage(Driver);
    }

    @AfterSuite
    public void TearDown(){

        BrowserHelpers.KillBrowser();
    }
}
