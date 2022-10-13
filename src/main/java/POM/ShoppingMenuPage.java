package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingMenuPage extends BasePage{
    private WebDriver _driver;

    public ShoppingMenuPage(WebDriver driver){
        super(driver);

        _driver = driver;

        Visible = IsPageVisible();
    }
    private static By LatestPromotionsLabel = By.id("menu-column--2599970378");
    private static By OnlineExclusiveDealsLink = By.xpath("//*[@id='menu-column--2599970378-item-2-link']");

    public void OpenOnlineExclusiveDeals(){
        ClickElement(OnlineExclusiveDealsLink);
    }

    private Boolean IsPageVisible() {
        return WaitForElementVisible(LatestPromotionsLabel);
    }
}
