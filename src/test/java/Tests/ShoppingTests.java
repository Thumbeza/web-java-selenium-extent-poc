package Tests;

import POM.DealDetailsPage;
import POM.OnlineExclusiveDealsPage;
import POM.OrderSummaryPage;
import POM.ShoppingMenuPage;
import TestData.Devices;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class ShoppingTests extends BaseTest{
    @Test(description = "Get a contract deal")
    public void GetDeal(){
        assertTrue(LandingPage.Visible);

        LandingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails(Devices.SamsungGalaxyA35);

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        assertTrue(dealDetailsPage.Visible);
        assertTrue(dealDetailsPage.GetDeviceName().contains(Devices.SamsungGalaxyA35));

        String contractTermsPreDeal = dealDetailsPage.GetPriceAndContractTerm();

        dealDetailsPage.GetDeal();

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(Driver);
        assertTrue(orderSummaryPage.Visible);

        orderSummaryPage.RemoveContractCover();
        String contractTermsPostDeal = orderSummaryPage.GetPriceAndContractTerm();

        assertEquals(
                contractTermsPreDeal,
                contractTermsPostDeal,
                "contract values are not the same pre and post getting the deal");
    }

    @Test(description = "Get a contract deal and verify with invalid price")
    public void GetDealWithIncorrectPrice() {
        assertTrue(LandingPage.Visible);

        LandingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails(Devices.SamsungGalaxyS21);

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        assertTrue(dealDetailsPage.Visible);
        assertTrue(dealDetailsPage.GetDeviceName().contains(Devices.SamsungGalaxyS21));

        String contractTermsPreDeal = dealDetailsPage.GetPriceAndContractTerm();
        String contractPrice = contractTermsPreDeal.substring(0,4);

        assertEquals(
                contractPrice,
                "R158",
                "The contract price is different to the expected price");
    }
}
