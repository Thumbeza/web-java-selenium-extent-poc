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
        By deviceDetailsLink = By.xpath(
                "//div[@id='Deal-Card']/div[2]//div[@class='DealCard_image-text-content__13qd9']/span[contains(.,'"+deviceName+"')]");

        ClickElement(deviceDetailsLink);
    }

    private Boolean IsPageVisible() {

        return WaitForElementVisible(BrowserAllDealsLabel);
    }

}
