package netahsilatUI.tests.genel;

import jdk.jfr.Description;
import netahsilatUI.pagesElements.*;
import netahsilatUI.utilities.BaseDriver;
import netahsilatUI.utilities.Retry;
import netahsilatUI.utilities.Tools;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Genel extends BaseDriver {
    WebDriver driver;

    LoginPageElements loginPageElements;
    MainPageElements mainPageElements;
    NavbarElements navbarElements;
    ProfilBilgileriPageElements profilBilgileriPageElements;
    YonetimPaneliPageElements yonetimPaneliPageElements;


    @Parameters("browser")
    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
    void setDriver(@Optional("browser") String browser) {
        System.out.println("Browser name = " + browser);
        BaseDriver.threadBrowserName.set(browser);
        this.driver = getDriver();

        loginPageElements = new LoginPageElements(driver);
        mainPageElements = new MainPageElements(driver);
        navbarElements = new NavbarElements(driver);
        profilBilgileriPageElements = new ProfilBilgileriPageElements(driver);
    }

    @AfterMethod
    void teardown() {
        BaseDriver.DriverQuit();
    }

    @Test(testName = "C2381 Kullanıcı/Tenant Bilgisi - Tenant Değiştirme",retryAnalyzer = Retry.class,
            groups = {"Regression", "Smoke"}, priority = 1)
    @Description("")
    void C2381() {
        Tools.navigateApplications(driver, "https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("ortaknetekstre@yandex.com", "Kd!cyhz4");
        navbarElements.waitUntilVisible(navbarElements.getUserOrtakYetkiliKullanici());
        navbarElements.moveToElement(navbarElements.getUserOrtakYetkiliKullanici(), driver);
        navbarElements.clickFunction(navbarElements.getUserOrtakYetkiliKullanici());
        navbarElements.waitUntilVisible(navbarElements.getUserOtomasyonNetfinans());
        navbarElements.sendKeysFunction(navbarElements.getInputFirmaAra(), "OTM");
        navbarElements.clickFunction(navbarElements.getUserOtomasyonNetfinans());
        navbarElements.waitUntilVisible(navbarElements.getTextFirmaDegisiyor());
    }

    @Test(testName = "C2382 Kullanıcı/Tenant Bilgisi - Ayarlar",retryAnalyzer = Retry.class,
            groups = {"Regression", "Smoke"}, priority = 2)
    @Description("")
    void C2382() {
        Tools.navigateApplications(driver, "https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("ortaknetekstre@yandex.com", "Kd!cyhz4");
        navbarElements.waitUntilVisible(navbarElements.getUserOrtakYetkiliKullanici());
        navbarElements.clickFunction(navbarElements.getDropDownProfile());
        navbarElements.clickFunction(navbarElements.getBtnAyarlar());
        profilBilgileriPageElements.waitUntilVisible(profilBilgileriPageElements.getBtnEpostaDegistir());
        profilBilgileriPageElements.verifyElementContainsText(profilBilgileriPageElements.getTxtProfilBilgileri(), "Profil Bilgileri");
    }

    @Test(testName = "C2384 Kullanıcı/Tenant Bilgisi - Ana Ekrana Dön",retryAnalyzer = Retry.class,
            groups = {"Regression", "Smoke"}, priority = 3)
    @Description("")
    void C2384() {
        Tools.navigateApplications(driver, "https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("ortaknetekstre@yandex.com", "Kd!cyhz4");
        navbarElements.waitUntilVisible(navbarElements.getUserOrtakYetkiliKullanici());
        navbarElements.clickFunction(navbarElements.getDropDownProfile());
        navbarElements.clickFunction(navbarElements.getBtnAyarlar());
        profilBilgileriPageElements.waitUntilVisible(profilBilgileriPageElements.getBtnEpostaDegistir());
        profilBilgileriPageElements.verifyElementContainsText(profilBilgileriPageElements.getTxtProfilBilgileri(), "Profil Bilgileri");
        navbarElements.clickFunction(navbarElements.getDropDownProfile());
        navbarElements.clickFunction(navbarElements.getBtnAnaEkranaDon());
        mainPageElements.waitUntilClickable(mainPageElements.getBtnNetekstreModulu());
    }

    @Test(testName = "C2383 Kullanıcı/Tenant Bilgisi - Yönetim Paneli3",retryAnalyzer = Retry.class,
            groups = {"Regression", "Smoke"}, priority = 4)
    @Description("")
    void C2383() {
        Tools.navigateApplications(driver, "https://otomasyon.netfinans.com");
        loginPageElements.InvalidLogin("yonetimnetekstre@yandex.com", "Kd!cyhz4");
        navbarElements.clickFunction(navbarElements.getDropDownProfile());
        navbarElements.clickFunction(navbarElements.getBtnAyarlar());
        profilBilgileriPageElements.waitUntilVisible(profilBilgileriPageElements.getBtnEpostaDegistir());
        profilBilgileriPageElements.verifyElementContainsText(profilBilgileriPageElements.getTxtProfilBilgileri(), "Profil Bilgileri");
        navbarElements.clickFunction(navbarElements.getDropDownProfile());
        navbarElements.clickFunction(navbarElements.getBtnYonetimPaneli());
        yonetimPaneliPageElements = new YonetimPaneliPageElements(driver);
        yonetimPaneliPageElements.waitUntilClickable(yonetimPaneliPageElements.getBtnListele());
        yonetimPaneliPageElements.verifyElementContainsText(yonetimPaneliPageElements.getColumnFirmaAdi(), "FIRMA ADI");
    }
}
