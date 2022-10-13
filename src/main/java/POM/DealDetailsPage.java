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
    private static By PriceLabel = By.xpath("//span[@class='productDetailPrice_deal-amount__37IDW']");
    private static By ContractTermLabel = By.xpath("//span[@class='productDetailPrice_deal-amount__37IDW'][2]");
    private static By GetThisDealButton = By.xpath("//button[text()='Get this deal']");

    private Boolean IsPageVisible() {

        return WaitForElementVisible(DealDetailsLabel);
    }

    public String GetPriceAndContractTerm(){

        String price = GetElementText(PriceLabel);
        String contractTerm = GetElementText(ContractTermLabel);

        return (price + contractTerm).trim();
    }

    public void GetDeal(){

        ClickElement(GetThisDealButton);
    }
}
