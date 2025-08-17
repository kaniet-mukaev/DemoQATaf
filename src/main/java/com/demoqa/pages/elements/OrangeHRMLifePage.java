package com.demoqa.pages.elements;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLifePage extends BasePage {

    @FindBy(css = "input[name='username']")
    public WebElement inputUsername;

    @FindBy(css = "input[name='password']")
    public WebElement inputUserPassword;

    @FindBy(css = "button[type='submit']")
    public WebElement buttonSubmit;

    public void signIn(String userName, String userPassword) {
        actions.waitElementToBeDisplayed(inputUsername);
        actions.waitElementToBeDisplayed(inputUserPassword);
        actions.type(inputUsername, userName).type(inputUserPassword, userPassword).click(buttonSubmit);
    }
}
