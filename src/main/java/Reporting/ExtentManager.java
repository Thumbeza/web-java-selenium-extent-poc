package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports ExtentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Vodacom End to End Regression");

        ExtentReports.attachReporter(reporter);
        ExtentReports.setSystemInfo("Author", "Igama lemama");

        return ExtentReports;
    }
}
