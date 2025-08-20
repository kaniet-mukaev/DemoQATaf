package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class WebElementActions {

    private Select select;

    private final Actions actions = new Actions(DriverManager.getDriver());
    private final JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();  ;

    public WebElementActions click(WebElement element) {
        scrollToElement(element);
        waitElementToBeDisplayed(element).waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public WebElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions type(WebElement element, String text) {
        scrollToElement(element);
        waitElementToBeDisplayed(element);
        element.sendKeys(text);
        return this;
    }

    public WebElementActions typeWithEnter(WebElement element, String text) {
        scrollToElement(element);
        waitElementToBeDisplayed(element);
        element.sendKeys(text + Keys.ENTER);
        return this;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElementActions selectByText(WebElement element, String text) {
        select = new Select(element);
        select.selectByVisibleText(text);
        return this;
    }

    public WebElementActions selectByIndex(WebElement element, int index) {
        select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    public WebElementActions selectByValue(WebElement element, String value) {
        select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    public List<String> getAllDropdownValues(WebElement element) {
        select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<>();
        for (WebElement e : elementList) {
            valueList.add(e.getText());
        }
        return valueList;
    }

    public WebElementActions doubleClick(WebElement element) {
        highlightElement(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightClick(WebElement element) {
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    public WebElementActions highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
        return this;
    }

    public String getText(WebElement element) {
        waitElementToBeDisplayed(element);
        return element.getText();
    }
}
