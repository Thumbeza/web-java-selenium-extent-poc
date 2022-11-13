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
        GetTest().log(Status.SKIP, "Test Skipped");
    }
}
