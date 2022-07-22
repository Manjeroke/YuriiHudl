package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Base64;

public class General {

    public WebDriver driver;

    public General(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickButton(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void enterText(By locator, String text){
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public void enterEncryptedText(By locator, String text){
        WebElement inputField = driver.findElement(locator);
        inputField.clear();
        byte[] decPass = Base64.getDecoder().decode(text);
        inputField.sendKeys(new String(decPass));
    }

    public String getElementText(By locator){
        WebElement elementText = driver.findElement(locator);
        waitForElementToBeVisible(locator);
        String text = elementText.getText();
        return text;
    }
    public String getTitleName(){
        String title = driver.getTitle();
        return title;
    }

    public String getUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }

    public void hoverOverElement(By locator){
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void verifyElementIsDisplayed(By locator){
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed());
    }
}
