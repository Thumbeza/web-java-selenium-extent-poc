package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver _driver;
    private WebDriverWait _wait;
    private static final int WaitInSeconds = 10;

    public BasePage(WebDriver driver){
        _driver = driver;

        _wait = new WebDriverWait(_driver, Duration.ofSeconds(WaitInSeconds));
    }

    public Boolean Visible;

    public Boolean WaitForElementClickable(By by){
        try{
            _wait.until(ExpectedConditions.elementToBeClickable(by));

            return true;
        }
        catch (Exception exception){
            return false;
        }
    }

    public Boolean WaitForElementVisible(By by){
        try{
            _wait.until(ExpectedConditions.visibilityOfElementLocated(by));

            return true;
        }
        catch (Exception exception){
            return false;
        }
    }

    public void MouseHover(By by){
        WaitForElementVisible(by);

        Actions action = new Actions(_driver);

        action.moveToElement(_driver.findElement(by)).perform();
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
