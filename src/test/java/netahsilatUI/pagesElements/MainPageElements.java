package netahsilatUI.pagesElements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import netahsilatUI.utilities.Parent;


@Getter
public class MainPageElements extends Parent{

    public MainPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div[class*='netekstre'] div[class='right-icon']")
    private WebElement btnNetekstreModulu;

}
