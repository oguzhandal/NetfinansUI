package netahsilatUI.pagesElements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import netahsilatUI.utilities.Parent;


@Getter //Lombok
public class SideBarElements extends Parent{

    public SideBarElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[. = 'Hesap Bakiyeleri']")
    private WebElement btnHesapBakiyeleri;

}
