package netahsilatUI.pagesElements;

import lombok.Getter;
import netahsilatUI.utilities.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@Getter
public class NavbarElements extends Parent {

    public NavbarElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[. = 'ORTAK Yetkili Kullanıcı']")
    private WebElement userOrtakYetkiliKullanici;
    @FindBy(xpath = "//li[. = 'OTM. NETFİNANS 2.FİRMA']")
    private WebElement userOtomasyonNetfinans;
    @FindBy(xpath = "//input[@placeholder = 'Firma ara']")
    private WebElement inputFirmaAra;
    @FindBy(xpath = "//*[text()='Firma değiştiriliyor']")
    private WebElement textFirmaDegisiyor;
    @FindBy(xpath = "(//span[@class='header-profile ']//i)[2]")
    private WebElement dropDownProfile;
    @FindBy(xpath = "//li[. = 'Ana Ekrana Dön']")
    private WebElement btnAnaEkranaDon;
    @FindBy(xpath = "//li[. = 'Yönetim Paneli']")
    private WebElement btnYonetimPaneli;
    @FindBy(xpath = "//li[. = 'Ayarlar']")
    private WebElement btnAyarlar;


}
