package Browsers;

import org.openqa.selenium.WebDriver;

public interface IBrowserFactory {
    WebDriver GetDriver();
    WebDriver GetDriver(Browser browserName) throws Exception;
}
