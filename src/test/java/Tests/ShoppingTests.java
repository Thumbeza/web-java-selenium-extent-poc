package Tests;

import POM.*;
import Reporting.ExtentTestManager;
import TestData.DeviceName;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest{
    private ExtentTest _test;

    @Test
    public void GetDeal(){

        try {
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

            ExtentTestManager.PassTest(_test);

        }
        catch (Exception exception) {
            ExtentTestManager.FailTest(_test, exception, BrowserHelpers.TakeScreenshotAsBase64());
            throw exception;
        }
    }

    @Test
    public void GetDealWithIncorrectPrice() {

        try {
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

            ExtentTestManager.PassTest(_test);

        } catch (Exception exception) {
            ExtentTestManager.FailTest(_test, exception, BrowserHelpers.TakeScreenshotAsBase64());
            throw exception;
        }
    }
}
