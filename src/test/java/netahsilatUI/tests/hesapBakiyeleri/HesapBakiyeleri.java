package netahsilatUI.tests.hesapBakiyeleri;


import jdk.jfr.Description;
import netahsilatUI.utilities.Retry;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import netahsilatUI.pagesElements.HesapBakiyeleriPageElements;
import netahsilatUI.pagesElements.LoginPageElements;
import netahsilatUI.pagesElements.MainPageElements;
import netahsilatUI.pagesElements.SideBarElements;
import netahsilatUI.utilities.BaseDriver;
import netahsilatUI.utilities.Tools;


public class HesapBakiyeleri extends BaseDriver {
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

    @Test(testName = "C2421 Hesap Bakiyeleri - Grid - Sayfalama (Pagination)",retryAnalyzer = Retry.class,
            groups = { "Regression", "Smoke" },priority = 1)
    @Description("")
    void C2421(){
        Tools.navigateApplications(driver,"https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("ortaknetekstre@yandex.com","Kd!cyhz4");
        mainPageElements.clickFunction(mainPageElements.getBtnNetekstreModulu());
        sideBarElements.clickFunction( sideBarElements.getBtnHesapBakiyeleri());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hesapBakiyeleriPageElements.getBtnListele());
        hesapBakiyeleriPageElements.clickFunction(hesapBakiyeleriPageElements.getDropDownPagination());
        hesapBakiyeleriPageElements.fetchAllDataAsList(hesapBakiyeleriPageElements.getListPaginationOptions(),
                "10 / sayfa,25 / sayfa,50 / sayfa,100 / sayfa,");
    }
    @Test(testName = "C2417_Hesap_Bakiyeleri_Filtreleme",retryAnalyzer = Retry.class,
            groups = { "Regression", "Smoke" },priority = 2)
    @Description("")
    void C2417(){
        Tools.navigateApplications(driver,"https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("ortaknetekstre@yandex.com","Kd!cyhz4");
        mainPageElements.clickFunction(mainPageElements.getBtnNetekstreModulu());
        sideBarElements.clickFunction( sideBarElements.getBtnHesapBakiyeleri());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hesapBakiyeleriPageElements.getBtnListele());
    }
}
