package Tests;

import POM.*;
import TestData.DeviceName;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest{
    private ExtentTest _test;

    @Test(description = "Get a contract deal")
    public void GetDeal(){
        LandingPage landingPage = new LandingPage(Driver);
        Assert.assertTrue(landingPage.Visible);

        landingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        Assert.assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        Assert.assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails(DeviceName.GalaxyA33);

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        Assert.assertTrue(dealDetailsPage.Visible);
        Assert.assertEquals(DeviceName.GalaxyA33, dealDetailsPage.GetDeviceName());

        //create a validation point

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(Driver);
        Assert.assertTrue(orderSummaryPage.Visible);
    }

    @Test(description = "Get a contract deal and verify with invalid price")
    public void GetDealWithIncorrectPrice() {
        LandingPage landingPage = new LandingPage(Driver);
        Assert.assertTrue(landingPage.Visible);

        landingPage.OpenShoppingMenu();

        ShoppingMenuPage shoppingMenuPage = new ShoppingMenuPage(Driver);
        Assert.assertTrue(shoppingMenuPage.Visible);

        shoppingMenuPage.OpenOnlineExclusiveDeals();

        OnlineExclusiveDealsPage onlineExclusiveDealsPage = new OnlineExclusiveDealsPage(Driver);
        Assert.assertTrue(onlineExclusiveDealsPage.Visible);

        onlineExclusiveDealsPage.SeeDeviceDetails(DeviceName.GalaxyA33);

        DealDetailsPage dealDetailsPage = new DealDetailsPage(Driver);
        Assert.assertTrue(dealDetailsPage.Visible);
        Assert.assertEquals(DeviceName.GalaxyA33, dealDetailsPage.GetDeviceName());
    }
}
