package com.demoqa.pages.adidas.loginUser;

import com.demoqa.drivers.DriverManager;
import com.demoqa.enams.Title;
import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement enterAccountInformationHeader;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement selectDays;

    @FindBy(id = "months")
    public WebElement selectMonths;

    @FindBy(id = "years")
    public WebElement selectYears;

    @FindBy(id = "newsletter")
    public WebElement checkboxNewsletter;

    @FindBy(id = "optin")
    public WebElement checkboxOption;

    @FindBy(id = "first_name")
    public WebElement firstNameInput;

    @FindBy(id = "last_name")
    public WebElement lastNameInput;

    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement address1Input;

    @FindBy(id = "address2")
    public WebElement address2Input;

    @FindBy(id = "country")
    public WebElement countrySelect;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobile_number;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @Step("enter new password {0}")
    public SignUpPage enterNewPassword(String inputPassword) {
        actions.type(password, inputPassword);
        return this;
    }

    @Step("select date of birth {0}")
    public SignUpPage selectDateMonthYearCalendar(String dateMonthYear) {

        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        actions.selectByText(selectDays, day);
        actions.selectByText(selectMonths, month);
        actions.selectByText(selectYears, year);
        return this;
    }

    @Step("click checkbox newsletter")
    public SignUpPage clickCheckboxNewsletter() {
        actions.click(checkboxNewsletter);
        return this;
    }

    @Step("click checkbox option")
    public SignUpPage clickCheckboxOption() {
        actions.click(checkboxOption);
        return this;
    }

    @Step("select gender {0}")
    public SignUpPage fillTitle(Title title) {
       WebElement element = DriverManager.getDriver().findElement(By.xpath("//input[@value='"+ title.getTitle() +"']"));
       actions.click(element);
       return this;
    }

    @Step("fill first name {0}")
    public SignUpPage fillFirstName(String firstName) {
        actions.type(firstNameInput, firstName);
        return this;
    }

    @Step("fill last name {0}")
    public SignUpPage fillLastName(String lastName) {
        actions.type(lastNameInput, lastName);
        return this;
    }

    @Step("enter company name {0}")
    public SignUpPage enterCompanyName(String companyName) {
        actions.type(companyInput, companyName);
        return this;
    }

    @Step("fill address {0}")
    public SignUpPage fillAddress(String address) {
        actions.type(address1Input, address);
        return this;
    }

    @Step("fill address2 {0}")
    public SignUpPage fillAddress2(String address) {
        actions.type(address2Input, address);
        return this;
    }

    @Step("select country {0}")
    public SignUpPage selectCounty(String country) {
        actions.selectByText(countrySelect, country);
        return this;
    }

    @Step("fill state {0}")
    public SignUpPage fillState(String inputState) {
        actions.type(state, inputState);
        return this;
    }

    @Step("fill city {0}")
    public SignUpPage fillCity(String inputCity) {
        actions.type(city, inputCity);
        return this;
    }

    @Step("fill zipcode")
    public SignUpPage fillZipcode(String inputZipcode) {
        actions.type(zipcode, inputZipcode);
        return this;
    }

    @Step("fill mobile number")
    public SignUpPage fillMobileNumber(String inputMobileNumber) {
        actions.type(mobile_number, inputMobileNumber);
        return this;
    }

    @Step("click create account btn")
    public AccountCreatedPage clickCreateAccountBtn() {
        actions.click(createAccountButton);
        return new AccountCreatedPage();
    }
}