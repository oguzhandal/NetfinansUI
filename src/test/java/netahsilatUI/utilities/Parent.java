package netahsilatUI.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Parent {
    Actions actions;
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();

    public void sendKeysFunction(WebElement element, String value) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);
    }
    public void clickFunction(WebElement element) {
        waitUntilVisible(element);
        waitUntilClickable(element);
        element.click();
    }
    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void elementsToBeMoreThan(By locator, int piece) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, piece));
    }

    public void verifyElementContainsText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        Assert.assertTrue(webElement.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public static void delay(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyElement(WebElement element) {
        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void listSelection(List<WebElement> list, String expected) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getText().equals(expected)) {
                clickFunction(list.get(i));
                break;
            }
        }
    }

    public void listSelection(List<WebElement> list, int expected) {
        for (int i = 0; i < list.size(); i++) {
            if (i == expected) {
                clickFunction(list.get(i));
                break;
            }
        }
    }

    public void moveToElement(WebElement element, WebDriver driver) {
        actions = new Actions(driver);
        Action action = actions.moveToElement(element).build();
        action.perform();
    }

    public void moveToElementAndClick(WebElement element, WebDriver driver) {
        actions = new Actions(driver);
        Action action = actions.moveToElement(element).click().build();
        action.perform();
    }

    public void fetchAllDataAsList(List<WebElement> elements, String string) {
        String output = " ";
        if (elements.size() > 0) {
            for (WebElement e : elements) {
                waitUntilVisible(e);
                if (e.getText().length() > 0 && !e.getText().equals(" ")) {
                    output += e.getText() + ",";
                    output = output.trim();
                }
            }
            Assert.assertEquals(output, string, "burası hatalı");
        }
    }


}



