package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void init(String browser) throws InterruptedException {
        if(browser.equals("Chrome")){
            driver = WebDriverManager.chromedriver().create();
        }
        else if(browser.equals("Firefox")){
            driver = WebDriverManager.firefoxdriver().create();
        }
        else {
            throw new InterruptedException("Unexpected value");
        }

    }


}
