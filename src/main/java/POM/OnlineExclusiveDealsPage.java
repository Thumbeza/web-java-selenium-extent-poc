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
    private static By SeeDetailsLink = By.xpath("//span[text()='See details'][1]");

    public void SeeDeviceDetails(){

        ClickElement(SeeDetailsLink);
    }

    private Boolean IsPageVisible() {

        return WaitForElementVisible(BrowserAllDealsLabel);
    }

}
