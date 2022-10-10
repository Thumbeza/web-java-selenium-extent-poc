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
    private static By PriceLabel = By.xpath("//span[@class='dprice ng-binding']");
    private static By ContractTermLabel = By.xpath("//span[@class='price_details ng-binding']");

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

    public String GetPriceAndContractTerm()
    {
        String price = GetElementText(PriceLabel);
        String contractTerm = GetElementText(ContractTermLabel);

        return (price + contractTerm).trim();
    }

    private Boolean IsPageVisible() {
        return WaitForElementVisible(OrderSummaryLabel);
    }
}
