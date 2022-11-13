package Tests;

import Browsers.BrowserFactory;
import POM.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    public LandingPage LandingPage;
    public WebDriver Driver;

    @BeforeClass
    public void Setup(){
        _browserFactory = new BrowserFactory();
    }

    private BrowserFactory _browserFactory;

    @BeforeMethod
    public void TestSetup() throws Exception {
        //Chrome will be returned by default.
        //If you wish to use edge, call the GetDriver(Browser.Edge) overload
        Driver = _browserFactory.GetDriver();

        LandingPage = new LandingPage(Driver);
    }

    @AfterMethod
    public void TestTearDown(){
        Driver.quit();
    }

    @AfterClass
    public void TearDown(){
        if (Driver != null)
            Driver.quit();
    }
}
