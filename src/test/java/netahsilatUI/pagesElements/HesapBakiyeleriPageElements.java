package netahsilatUI.pagesElements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import netahsilatUI.utilities.Parent;

import java.util.List;

@Getter
public class HesapBakiyeleriPageElements extends Parent{
    public HesapBakiyeleriPageElements(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='ant-pagination-options']//li[@role='option']") //
    private List<WebElement> listPaginationOptions;
    @FindBy(css = "#antContainerScroll > div > div.fadeInComponent > div > div > div > div > div.ant-collapse-content.ant-collapse-content-active > div > form > div > div.ant-col.text-center.mb-15.ant-col-xs-24.ant-col-lg-0 > button")
    private WebElement btnListele;
    @FindBy(xpath = "//li[@class='ant-pagination-options']//i")
    private WebElement dropDownPagination;
    @FindBy(xpath = "//li[@class='ant-pagination-options']//li[@role='option']")
    private WebElement optionsPagination;


}
