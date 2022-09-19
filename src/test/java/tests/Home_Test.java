package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.pageObjects.HomePageObject;
import pages.pageObjects.LoginPageObject;
import pages.pageUIs.HomePageUI;
import untils.ExcelUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Home_Test extends BaseTest {
    LoginPageObject objLogin;
    HomePageObject objHome;
    static String path = System.getProperty("user.dir");


    @Parameters("url")
    @BeforeClass
    public void setup(String url) throws IOException, InterruptedException {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        objHome = new HomePageObject(driver);
        objLogin = new LoginPageObject(driver);
        String[][] tableData= new String[0][];
        try {
            tableData = ExcelUtil.getDataFromExcel(path + "\\src\\test\\java\\resources\\TestDataLogin.xlsx", "DataLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        objLogin.enterToEmailTxt(tableData[0][0]);
        objLogin.enterToPasswordTxt(tableData[0][1]);
        objLogin.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        objHome.clickAddProdLink();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getCurrentUrl());

    }

    @Test(dataProvider = "addPrdData", dataProviderClass = Data.class)
    public void TC1_Add_Prd(String name, String category, String intro, String detail, String featured, String price, String discount, String img, String locator) throws InterruptedException {
        objHome.clear();
        objHome.enterToPrdName(name);
        objHome.enterToCategory(category);
        objHome.enterToPrdIntro(intro);
        objHome.enterToPrdDetail(detail);
        objHome.enterToPrdFeatured(featured);
        objHome.enterToPrice(price);
        objHome.enterToDiscount(discount);
        objHome.enterToImage(path, img);
        objHome.clickAddPrdBtn();
        Assert.assertEquals(objLogin.verityOK(locator), true);
        boolean result = objLogin.verityOK(locator);
        System.out.println("Tên: " + name + "\tDanh mục: " + category + "\tGiới thiệu: " + intro + "\tChi tiết: " + detail + "\tNổi bật: " + featured + "\tGia: " + price + "\tGiam gia: " + discount  + "\tResult: " + result);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
