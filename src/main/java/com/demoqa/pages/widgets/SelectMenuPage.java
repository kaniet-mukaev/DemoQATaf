package com.demoqa.pages.widgets;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectMenuPage extends BasePage {
    @FindBy(id = "oldSelectMenu")
    public WebElement oldSelectMenu;

    @FindBy(id = "react-select-2-input")
    public WebElement selectValueMenu;

    @FindBy(xpath = "//div/input[@id='react-select-2-input']/parent::div/parent::div/parent::div/child::div[1]")
    public WebElement resultOfSelectValueMenu;

    @FindBy(id = "react-select-3-input")
    public WebElement selectOneMenu;

    @FindBy(css = "#selectOne > div > div.css-1hwfws3 > div.css-1uccc91-singleValue")
    public WebElement resultOfSelectOneMenu;

    public void selectValueByText(String text) {
        actions.type(selectValueMenu, text);
        selectValueMenu.sendKeys(Keys.ENTER);
    }

    public void selectOneByText(String text) {
        actions.type(selectOneMenu, text);
        selectOneMenu.sendKeys(Keys.ENTER);
    }
}
