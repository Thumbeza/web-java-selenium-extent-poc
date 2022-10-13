package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static final ExtentReports ExtentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Vodacom End to End Regression");
        reporter.config().setTheme(Theme.DARK);

        ExtentReports.attachReporter(reporter);
        ExtentReports.setSystemInfo("Author", "Author of the report");

        return ExtentReports;
    }
}
