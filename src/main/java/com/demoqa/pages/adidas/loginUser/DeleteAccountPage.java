package com.demoqa.pages.adidas.loginUser;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeletedIsVisible;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @Step("click continue btn")
    public HomePage clickContinueBtn() {
        actions.click(continueButton);
        return new HomePage();
    }
}