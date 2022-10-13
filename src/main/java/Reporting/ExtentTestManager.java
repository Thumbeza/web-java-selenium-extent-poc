package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports Extent = ExtentManager.CreateExtentReports();

    public static synchronized ExtentTest GetTest() {

        ExtentTest test = extentTestMap.get((int) Thread.currentThread().getId());

        return test;
    }

    public static synchronized ExtentTest StartTest(String testName) {
        ExtentTest test = Extent.createTest(testName);
        extentTestMap.put((int)Thread.currentThread().getId(), test);

        return test;
    }


}
