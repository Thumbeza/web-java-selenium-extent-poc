package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class ExtentService {
    public static void StartReport(){
        ExtentReporter extentReporter = new ExtentReporter() {};

        ExtentReports reports = new ExtentReports();

        reports.attachReporter();
    }
}
