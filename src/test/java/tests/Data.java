package tests;

import org.testng.annotations.DataProvider;
import untils.ExcelUtil;

import java.io.IOException;

public class Data {
    String path = System.getProperty("user.dir");
    @DataProvider(name = "loginData")
    public Object[][] dataLogin() throws IOException {
        Object[][] testObject = ExcelUtil.getDataFromExcel(path + "\\src\\test\\java\\resources\\TestDataLogin.xlsx","DataLogin");
        return testObject;
    }
    @DataProvider(name = "addPrdData")
    public Object[][] dataPrd() throws IOException {
        Object[][] testObject = ExcelUtil.getDataFromExcel(path + "\\src\\test\\java\\resources\\TestDataLogin.xlsx","AddPrdData");
        return testObject;
    }

}