package com.demoqa.pages.alertsWindows;

import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindows extends BasePage {

    @FindBy(id = "tabButton")
    public WebElement newTab;

    public BrowserWindows clickNewTabButton() {
        actions.click(newTab);
        return this;
    }


}
