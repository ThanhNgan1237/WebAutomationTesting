package pages.pageUIs;

public class HomePageUI {
    public static final String MENU = "//div[@class='menu']";
    public static final String ADD_PRD_LINK = "//a[contains(text(),'Thêm sản phẩm')]";
    public static final String PRD_NAME = "(//input[@class='el-input__inner'])[1]";
    public static final String PRD_CATEGORY = "(//input[@class='el-input__inner'])[2]";
    public static final String PRD_CATEGORY_ITEM1 = "(//li[@class='el-select-dropdown__item'])[1]";
    public static final String PRD_CATEGORY_ITEM = "//li[@class='el-select-dropdown__item']";
    public static final String PRD_INTRO = "(//textarea[@class='el-textarea__inner'])[1]";
    public static final String PRD_DETAIL = "(//textarea[@class='el-textarea__inner'])[2]";
    public static final String PRD_FEATURED = "//span[@class='el-checkbox__inner']";
    public static final String PRD_PRICE = "(//input[@class='el-input__inner'])[3]";
    public static final String PRD_DISCOUNT = "(//input[@class='el-input__inner'])[4]";
    public static final String PRD_IMG = "//input[@type='file']";
    public static final String ADD_PRD_BTN = "(//span[contains(text(),'Thêm sản phẩm')])/parent::*";
    public static final String RESET_BTN = "(//span[contains(text(),'Reset')])/parent::*";


}
