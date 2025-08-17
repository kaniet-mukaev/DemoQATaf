package com.demoqa.pages.adidas.loginUser;

import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement signUpHeaderIsVisible;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginToYourAccountIsVisible;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement signUpName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signUpEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Password']/following-sibling::p[text()='Your email or password is incorrect!']")
    public WebElement incorrectEmailOrPasswordError;

    @FindBy(xpath = "//a[normalize-space(text())='Home']")
    public WebElement homePageBtn;

    @FindBy(xpath = "//p[normalize-space(text())='Email Address already exist!']")
    public WebElement emailAlreadyExistError;

    @Step("fill username {0}")
    public LoginPage fillName(String username) {
        actions.type(signUpName, username);
        return this;
    }

    @Step("fill email {0}")
    public LoginPage fillEmail(String userEmail) {
        actions.type(signUpEmail, userEmail);
        return this;
    }

    @Step("click signup btn")
    public SignUpPage clickSignupBtn() {
        actions.click(signUpButton);
        return new SignUpPage();
    }

    @Step("login")
    public HomePage login(String userEmail, String userPassword) {
        actions.type(loginEmailInput, userEmail)
                .type(loginPasswordInput, userPassword)
                .click(loginButton);
        return new HomePage();
    }

    public HomePage switchToHomePage() {
        actions.click(homePageBtn);
        return new HomePage();
    }



}