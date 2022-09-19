package pages.pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driverObj;

    public LoginPageObject(WebDriver driver) {
        this.driverObj = driver;
    }

    public void enterToEmailTxt(String value) {
        sendKeysToElement(driverObj, LoginPageUI.TXT_EMAIL, value);
    }

    public void enterToPasswordTxt(String value) {
        sendKeysToElement(driverObj, LoginPageUI.TXT_PASSWORD, value);
    }

    public void clickLoginBtn() {
        clickToElement(driverObj, LoginPageUI.BTN_LOGIN);
    }

    public void clear() {
        clearKey(driverObj, LoginPageUI.TXT_EMAIL);
        clearKey(driverObj, LoginPageUI.TXT_PASSWORD);

    }
    public boolean verityOK(String locator) {
        setWait(driverObj);
        wait.until(ExpectedConditions.visibilityOf(getFindElementByXPath(driverObj, locator)));
        return isElementDisplayed(driverObj, locator);
    }

}
