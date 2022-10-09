package POM;

import Browsers.BrowserHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
    private WebDriver _driver;
    private BrowserHelpers _browserHelpers;

    public LandingPage(WebDriver driver){
        super(driver);

        _driver = driver;
        _browserHelpers = new BrowserHelpers(driver);

        Visible = IsPageVisible();
    }

    private static By ShopLink = By.id("menu-category--706522961-heading");

    public void OpenShoppingMenu(){
        ClickElement(ShopLink);
    }

    private Boolean IsPageVisible() {
        if(!_browserHelpers.GetDriverUrl().contains("https://www.vodacom.co.za/")) //must be moved to data class
        {
            _browserHelpers.LaunchUrl("https://www.vodacom.co.za/");
        }

        return WaitForElementVisible(ShopLink);
    }
}
