package Tests;

import POM.*;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest{
    private ExtentTest _test;

    @Test(description = "Get a contract deal")
    public void GetDeal(){
        Assert.assertTrue(LandingPage.Visible);

        LandingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        Assert.assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        Assert.assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails();

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        Assert.assertTrue(dealDetailsPage.Visible);

        String contractTermsPreDeal = dealDetailsPage.GetPriceAndContractTerm();

        dealDetailsPage.GetDeal();

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(Driver);
        Assert.assertTrue(orderSummaryPage.Visible);

        orderSummaryPage.RemoveContractCover();
        String contractTermsPostDeal = orderSummaryPage.GetPriceAndContractTerm();

        Assert.assertEquals(
                contractTermsPreDeal,
                contractTermsPostDeal,
                "contract values are not the same pre and post getting the deal");
    }

    @Test(description = "Get a contract deal and verify with invalid price")
    public void GetDealWithIncorrectPrice() {
        Assert.assertTrue(LandingPage.Visible);

        LandingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        Assert.assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        Assert.assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails();

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        Assert.assertTrue(dealDetailsPage.Visible);

        String contractTermsPreDeal = dealDetailsPage.GetPriceAndContractTerm();
        String contractPrice = contractTermsPreDeal.substring(0,4);

        Assert.assertEquals(contractPrice, "R158");
    }
}
