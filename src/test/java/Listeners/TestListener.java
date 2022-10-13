package Listeners;

import Reporting.ExtentManager;
import Reporting.ExtentTestManager;
import Tests.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Reporting.ExtentTestManager.GetTest;

public class TestListener extends BaseTest implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Override
    public void onStart(ITestContext iTestContext) {
        //Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.Driver);
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.ExtentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.StartTest(getTestMethodName(iTestResult));
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //Log.info(getTestMethodName(iTestResult) + " test is succeed.");

        GetTest().log(Status.PASS, "Test passed");
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();

        //String base64Screenshot = BrowserHelpers.TakeScreenshotAsBase64();
        GetTest().log(Status.FAIL, "Test Failed");
        //GetTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0)
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //Log.info(getTestMethodName(iTestResult) + " test is skipped.");

        GetTest().log(Status.SKIP, "Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
