package netahsilatUI.pagesElements;

import lombok.Getter;
import netahsilatUI.utilities.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ProfilBilgileriPageElements extends Parent {
    public ProfilBilgileriPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[. = ' E-Posta Değiştir ']")
    private WebElement btnEpostaDegistir;
    @FindBy(xpath = "//div[. = 'Profil Bilgileri']")
    private WebElement txtProfilBilgileri;

}
