package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
    private WebDriver _driver;

    public LandingPage(WebDriver driver) throws InterruptedException {
        super(driver);

        _driver = driver;

        Visible = IsPageVisible();
    }

    private static By ShopLink = By.id("menu-category--706522961-heading");
    private static By AcceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public void OpenShoppingMenu(){

        MouseHover(ShopLink);
    }

    private Boolean IsPageVisible() throws InterruptedException {
        if(!_driver.getCurrentUrl().contains("https://www.vodacom.co.za/"))
            _driver.get("https://www.vodacom.co.za/");//url must be moved to data file
        else
            _driver.navigate().refresh();

        Thread.sleep(1000);

        if(WaitForElementVisible(AcceptCookiesButton))
            ClickElement(AcceptCookiesButton);

        return WaitForElementVisible(ShopLink);
    }
}
