package pages.pageObjects;

import core.BasePage;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.pageUIs.HomePageUI;
import pages.pageUIs.LoginPageUI;


public class HomePageObject extends BasePage {
    WebDriver driverObj;

    public int RandomNumber(int min, int max) {
        int num = ThreadLocalRandom.current().nextInt(min,max);
        return num;
    }

    public String RandomString(int n) {
        String s = RandomStringUtils.randomAlphabetic(n);
        return s;
    }

    public void clear() {
        clickToElement(driverObj, HomePageUI.RESET_BTN);
    }

    public HomePageObject(WebDriver driver) {
        this.driverObj = driver;
    }

    public void clickAddProdLink() {
        clickToElement(driverObj, HomePageUI.ADD_PRD_LINK);
    }

    public void enterToPrdName(String value) {
        sendKeysToElement(driverObj, HomePageUI.PRD_NAME, value);
    }

    public void enterToCategory(String value) {
        if (value.equals("Random")) {
            clickToElement(driverObj, HomePageUI.PRD_CATEGORY);
            setWait(driverObj);
            wait.until(ExpectedConditions.visibilityOf(getFindElementByXPath(driverObj, HomePageUI.PRD_CATEGORY_ITEM1)));
            int randomNumber = RandomNumber(1,10);
            String PRD_CATEGORY_SELECT = HomePageUI.PRD_CATEGORY_ITEM + "[" + randomNumber + "]";
            clickToElement(driverObj, PRD_CATEGORY_SELECT);
        }
    }

    public void enterToPrdIntro(String value) {
        sendKeysToElement(driverObj, HomePageUI.PRD_INTRO, value);
    }

    public void enterToPrdDetail(String value) {
        if (value.equals("Random")) {
            String detail = RandomString(10);
            sendKeysToElement(driverObj, HomePageUI.PRD_DETAIL, detail);
        }
    }

    public void enterToPrdFeatured(String value) {
        if (value.equals("Yes"))
            clickToElement(driverObj, HomePageUI.PRD_FEATURED);
    }


    public void enterToPrice(String value) {
        sendKeysToElement(driverObj, HomePageUI.PRD_PRICE, value);
    }

    public void enterToDiscount(String value) {
        if (value.equals("Random")) {
            int randomNumber = RandomNumber(1,99);
            String discount = Integer.toString(randomNumber);
            sendKeysToElement(driverObj, HomePageUI.PRD_DISCOUNT, discount);
        }
    }

    public void enterToImage(String path, String imgPath) {
        String filePath = path + imgPath;
        getFindElementByXPath(driverObj, HomePageUI.PRD_IMG).sendKeys(filePath);
    }

    public void clickAddPrdBtn() {
        clickToElement(driverObj, HomePageUI.ADD_PRD_BTN);
    }


    public boolean verityOK(String locator) {
        setWait(driverObj);
        wait.until(ExpectedConditions.visibilityOf(getFindElementByXPath(driverObj, locator)));
        return isElementDisplayed(driverObj, locator);
    }


}
