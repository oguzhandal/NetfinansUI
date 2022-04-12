package netahsilatUI.tests.hesapBakiyeleri;


import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import netahsilatUI.pagesElements.HesapBakiyeleriPageElements;
import netahsilatUI.pagesElements.LoginPageElements;
import netahsilatUI.pagesElements.MainPageElements;
import netahsilatUI.pagesElements.SideBarElements;
import netahsilatUI.utilities.BaseDriver;
import netahsilatUI.utilities.Tools;


public class C2421 extends BaseDriver {
    WebDriver driver;

    LoginPageElements loginPageElements;
    HesapBakiyeleriPageElements hesapBakiyeleriPageElements;
    MainPageElements mainPageElements;
    SideBarElements sideBarElements;

    @Parameters("browser")
    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
    void setDriver(@Optional("browser") String browser){
        System.out.println("Browser name = "+browser);
        BaseDriver.threadBrowserName.set(browser);
        this.driver = getDriver();
        loginPageElements = new LoginPageElements(driver);
        hesapBakiyeleriPageElements = new HesapBakiyeleriPageElements(driver);
        mainPageElements = new MainPageElements(driver);
        sideBarElements = new SideBarElements(driver);
    }
    @AfterMethod
    void teardown() {
        BaseDriver.DriverQuit();
    }

    @Test()
    @Description("C2421_Hesap_Bakiyeleri")
    void C2421_Hesap_Bakiyeleri(){
        Tools.navigateApplications(driver,"https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin();
        mainPageElements.clickFunction(mainPageElements.getBtnNetekstreModulu());
        sideBarElements.clickFunction( sideBarElements.getBtnHesapBakiyeleri());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hesapBakiyeleriPageElements.getBtnListele());
        hesapBakiyeleriPageElements.clickFunction(hesapBakiyeleriPageElements.getDropDownPagination());
        hesapBakiyeleriPageElements.fetchAllDataAsList(hesapBakiyeleriPageElements.getListPaginationOptions(),
                "10 / sayfa,25 / sayfa,50 / sayfa,100 / sayfa,");
    }
}
