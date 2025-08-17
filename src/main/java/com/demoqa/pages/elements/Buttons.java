package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Buttons extends BasePage {

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickMeBtn;
}
