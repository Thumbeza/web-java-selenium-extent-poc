package Tests;

import Browsers.BrowserFactory;
import Browsers.BrowserHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public BrowserHelpers BrowserHelpers;

    public WebDriver Driver;

    @BeforeTest
    public void Setup(){
        BrowserFactory browserFactory = new BrowserFactory();

        Driver = browserFactory.GetDriver(); //returns chrome by default
        BrowserHelpers = new BrowserHelpers(Driver);
    }

    @AfterTest
    public void TearDown(){
        BrowserHelpers.KillBrowser();
    }
}
