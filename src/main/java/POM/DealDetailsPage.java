package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealDetailsPage extends BasePage{
    private WebDriver _driver;

    public DealDetailsPage(WebDriver driver){
        super(driver);

        _driver = driver;

        Visible = IsPageVisible();
    }

    private static By DealDetailsLabel = By.id("heading-Deal details");
    private static By DeviceNameLabel = By.xpath("//div[contains(@class, 'DependencyHelper__CustomContainer)]");

    public String GetDeviceName(){
        return GetElementText(DeviceNameLabel);
    }

    private Boolean IsPageVisible() {
        return WaitForElementVisible(DealDetailsLabel);
    }
}
