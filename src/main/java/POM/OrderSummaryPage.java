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
    private static By PriceLabel = By.xpath("//span[@class='price ng-binding']");
    private static By ContractTermLabel = By.xpath("//span[@class='price_details ng-binding']");

    public void RemoveContractCover(){
        if(WaitForElementVisible(RemoveCoverButton)){
            ClickElement(RemoveCoverButton);
        }
    }

    public String GetPriceAndContractTerm()
    {
        String price = GetElementText(PriceLabel);
        String actualPrice = price.substring(0, price.indexOf("."));
        String contractTerm = GetElementText(ContractTermLabel);

        return (actualPrice + contractTerm).trim();
    }

    private Boolean IsPageVisible() {


        return WaitForElementVisible(OrderSummaryLabel);
    }
}
