package netahsilatUI.utilities;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Tools extends BaseDriver {

    public static void navigateApplications(WebDriver driver , String URL) {
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
    }
}
