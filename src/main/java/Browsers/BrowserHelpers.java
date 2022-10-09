package Browsers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserHelpers {
    private WebDriver _driver;

    public BrowserHelpers(WebDriver driver){
        _driver = driver;
    }

    public void LaunchUrl(String url){
        _driver.get(url);
    }

    public String GetDriverUrl(){
        return _driver.getCurrentUrl();
    }

    public String TakeScreenshotAsBase64() {
        TakesScreenshot screenshot =((TakesScreenshot)_driver);

        return screenshot.getScreenshotAs(OutputType.BASE64);
    }

    public void KillBrowser() {
        _driver.quit();
    }
}
