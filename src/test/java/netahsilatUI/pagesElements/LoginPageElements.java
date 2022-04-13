package netahsilatUI.pagesElements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import netahsilatUI.utilities.Parent;

@Getter
public class LoginPageElements extends Parent{

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#username")
    private WebElement inputUserName;
    @FindBy(css = "#password")
    private WebElement inputPassword;
    @FindBy(css = "button[type='submit']")
    private WebElement btnLogin;


    public void InvalidLogin(String UserName, String Password) {
        sendKeysFunction(getInputUserName(), UserName);
        sendKeysFunction(getInputPassword(), Password);
        clickFunction(getBtnLogin());
    }

}
