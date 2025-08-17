package com.demoqa.pages.adidas.selections;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.adidas.loginUser.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouchIsVisible;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@name = 'subject']")
    public WebElement inputSubject;

    @FindBy(xpath = "//textarea[@id = 'message']")
    public WebElement inputMessage;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement submitBtn;

    @FindBy(xpath = "//input[@name = 'upload_file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//div[@class='status alert alert-success' and normalize-space(text())='Success! Your details have been submitted successfully.']")
    public WebElement successHeader;

    @FindBy(xpath = "//span[normalize-space(text())='Home']")
    public WebElement homeBtn;

    @Step("input user name")
    public ContactUsPage fillInputName(String name) {
        actions.type(inputName,name );
        return  this;
    }

    @Step("input user email")
    public ContactUsPage fillInputEmail(String email) {
        actions.type(inputEmail,email);
        return  this;
    }

    @Step("input user subject")
    public ContactUsPage fillInputSubject(String subject) {
        actions.type(inputSubject,subject);
        return  this;
    }

    @Step("input user subject")
    public ContactUsPage fillMessage(String message) {
        actions.type(inputMessage,message);
        return  this;
    }

    @Step("upload file")
    public ContactUsPage uploadFile(String path) {
        uploadFile.sendKeys(path);
        return this;
    }

    @Step("click submit")
    public ContactUsPage clickSubmit() {
        actions.click(submitBtn);
        return this;
    }

    @Step("accept alert")
    public ContactUsPage clickAlertAccept() {
        alertHelper.acceptAlertIfPresented();
        return this;
    }

    @Step("click home")
    public HomePage clickHome() {
        actions.click(homeBtn);
        return new HomePage();
    }
}
