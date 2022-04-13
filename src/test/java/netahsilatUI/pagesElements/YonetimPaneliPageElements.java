package netahsilatUI.pagesElements;

import lombok.Getter;
import netahsilatUI.utilities.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Getter
public class YonetimPaneliPageElements extends Parent {
    public YonetimPaneliPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='ant-pagination-options']//li[@role='option']") //
    private List<WebElement> listPaginationOptions;
    @FindBy(xpath = "//span[contains(text(),'Listele')]/..")
    private WebElement btnListele;
    @FindBy(xpath = "//li[@class='ant-pagination-options']//i")
    private WebElement dropDownPagination;
    @FindBy(xpath = "//li[@class='ant-pagination-options']//li[@role='option']")
    private WebElement optionsPagination;
    @FindBy(xpath = "//div[1]/form//span[. = 'Firma Adı']")
    private WebElement columnFirmaAdi;
}
