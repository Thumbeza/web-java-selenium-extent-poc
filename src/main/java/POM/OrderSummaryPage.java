package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BasePage{
    private WebDriver _driver;

    public OrderSummaryPage(WebDriver driver){
        super(driver);

        _driver = driver;

        Visible = IsPageVisible();
    }

    private static By OrderSummaryLabel = By.xpath("//p[@class='head' and text()='Order summary']");
    private static By RemoveCoverButton = By.xpath("//a[@ng-click='removeContractCover()' and text()='Remove Item']");
    private static By ContractDescriptionLabel = By.xpath("//div[@class='device_title ng-binding']");

    public void RemoveContractCover(){
        if(WaitForElementVisible(RemoveCoverButton)){
            ClickElement(RemoveCoverButton);
        }
    }

    public Boolean IsDeviceNameCorrect(String deviceName){
        if (GetElementText(ContractDescriptionLabel).startsWith(deviceName)) {
            return true;
        }

        return false;
    }

    private Boolean IsPageVisible() {
        return WaitForElementVisible(OrderSummaryLabel);
    }
}
