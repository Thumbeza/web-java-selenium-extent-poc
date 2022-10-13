package POM;

import Browsers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
    private WebDriver _driver;
    private BrowserHelpers _browserHelpers;

    public LandingPage(WebDriver driver) throws InterruptedException {
        super(driver);

        _driver = driver;
        _browserHelpers = new BrowserHelpers(driver);

        Visible = IsPageVisible();
    }

    private static By ShopLink = By.id("menu-category--706522961-heading");
    private static By AcceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public void OpenShoppingMenu(){

        MouseHover(ShopLink);
    }

    private Boolean IsPageVisible() throws InterruptedException {
        if(!_browserHelpers.GetDriverUrl().contains("https://www.vodacom.co.za/"))
            _browserHelpers.LaunchUrl("https://www.vodacom.co.za/"); //url must be moved to data file
        else
            _driver.navigate().refresh();

        Thread.sleep(1000);

        if(WaitForElementVisible(AcceptCookiesButton))
            ClickElement(AcceptCookiesButton);

        return WaitForElementVisible(ShopLink);
    }
}
