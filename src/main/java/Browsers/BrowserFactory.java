package Browsers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;

public class BrowserFactory implements IBrowserFactory{
    public WebDriver GetDriver() {
        return GetChrome();
    }

    public WebDriver GetDriver(Browser browserName) throws Exception {
        switch(browserName) {
            case Chrome:
                return GetChrome();
            case Edge:
                return GetEdge();
            default:
                throw new Exception("Invalid chrome browser, please select chrome or edge");
        }
    }

    private WebDriver GetChrome(){
        String chromePath = new File("src/main/java/Drivers/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", chromePath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    private WebDriver GetEdge(){
        String edgePath = new File("src/main/java/Drivers/chromedriver.exe").getPath();
        System.setProperty("webdriver.edge.driver", edgePath);

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        return driver;
    }
}
