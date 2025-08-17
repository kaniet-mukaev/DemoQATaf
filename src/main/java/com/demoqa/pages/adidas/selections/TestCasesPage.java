package com.demoqa.pages.adidas.selections;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TestCasesPage extends BasePage {

    @FindBy(xpath = "//a[@href='/test_cases' and contains(@style, 'orange')]")
    public WebElement testCasesOrange;

    @FindBy(xpath = "//h2[@class='title text-center']/child::b")
    public WebElement testCasesHeaderIsVisible;

    @Step("verify user is navigated to test cases page")
    public TestCasesPage verifyUserIsNavigatedToTestCasesPage() {
        Assert.assertEquals(testCasesOrange.getAttribute("style"), "color: orange;");
        return this;
    }
}
