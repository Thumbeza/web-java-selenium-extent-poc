package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver _driver;

    public BasePage(WebDriver driver){
        _driver = driver;
    }

    public Boolean Visible;

    public Boolean WaitForElementClickable(By by){
        return true;
    }

    public Boolean WaitForElementVisible(By by){
        return true;
    }

    public void ClickElement(By by){
        WaitForElementClickable(by);

        _driver.findElement(by).click();
    }

    public void InsertText(By by, String inputText){
        WaitForElementVisible(by);

        _driver.findElement(by).clear();
        _driver.findElement(by).sendKeys(inputText);
    }

    public String GetElementText(By by){
        WaitForElementVisible(by);

        return _driver.findElement(by).getText();
    }
}
