package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.pageObjects.HomePageObject;
import pages.pageObjects.LoginPageObject;
import untils.ExcelUtil;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login_Test extends BaseTest {
    LoginPageObject objLogin;
    HomePageObject objHome;
    String path = System.getProperty("user.dir");

    @Parameters("url")
    @BeforeMethod
    public void setup(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        objLogin = new LoginPageObject(driver);
        objHome = new HomePageObject(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = Data.class)
    public void TC_Login(String username, String password, String locator) throws InterruptedException, IOException {
        objLogin.clear();
        objLogin.enterToEmailTxt(username);
        objLogin.enterToPasswordTxt(password);
        objLogin.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(objLogin.verityOK(locator), true);
        boolean result = objLogin.verityOK(locator);
        System.out.println("Username: " + username + "\tPassword: " + password + "\tResult: " + result);
    }

}
