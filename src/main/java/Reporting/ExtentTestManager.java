package Reporting;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentTestManager {

    public static void CreateTest(String name, String description) {

    }
    public static void FailTest(ExtentTest test, Exception exception, String screenshot) {
        test.fail(exception);
        test.log(Status.INFO,
                "Screenshot: ", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    public static void PassTest(ExtentTest test) {
        test.pass("All assertions passed");
    }
}
