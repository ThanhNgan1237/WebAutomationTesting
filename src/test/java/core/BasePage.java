package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private long TIMEOUT = 15;
    public WebDriverWait wait;

    public void setWait(WebDriver driver) {
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public WebElement getFindElementByXPath(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void clearKey(WebDriver driver, String locator) {
        getFindElementByXPath(driver, locator).clear();
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value) {
        getFindElementByXPath(driver, locator).sendKeys(value);
    }


    public void clickToElement(WebDriver driver, String locator) {
        getFindElementByXPath(driver, locator).click();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getFindElementByXPath(driver, locator).isDisplayed();
    }
}
