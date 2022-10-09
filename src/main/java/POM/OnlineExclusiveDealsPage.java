package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnlineExclusiveDealsPage extends BasePage{
    private WebDriver _driver;

    public OnlineExclusiveDealsPage(WebDriver driver){
        super(driver);

        _driver = driver;

        Visible = IsPageVisible();
    }

    private static By BrowserAllDealsLabel = By.id("browse-heading");

    public void SeeDeviceDetails(String deviceName){
        By seeDetailsLink = By.xpath("");

        ClickElement(seeDetailsLink);
    }

    private Boolean IsPageVisible() {
        return WaitForElementVisible(BrowserAllDealsLabel);
    }

}
