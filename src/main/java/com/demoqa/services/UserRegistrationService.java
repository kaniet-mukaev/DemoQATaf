package com.demoqa.services;

import com.demoqa.data.MockDataService;
import com.demoqa.drivers.DriverManager;
import com.demoqa.enams.Title;
import com.demoqa.entity.User;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.adidas.loginUser.HomePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class UserRegistrationService {

    private static final String BASE_URL = "https://automationexercise.com/";

    private final WebDriver driver = DriverManager.getDriver();
    private final MockDataService dataService = new MockDataService();
    private final WebElementActions actions = new WebElementActions();

    public User registerNewUser() {
        // 1) Генерация данных
        String email = dataService.generateRandomEmail();
        String password = dataService.generateRandomPassword();
        String username = dataService.generateRandomFirstName();

        // 2) Открыть сайт и перейти к регистрации (без BaseTest.open)
        driver.get(BASE_URL);
        HomePage homePage = new HomePage();                  // BasePage initElements сработает в конструкторе
        var loginPage = homePage.verifyPageIsLoaded()
                .clickSignupLoginBtn();

        // 3) Шаги регистрации + проверки
        SoftAssert softAssert = new SoftAssert();
        Allure.step("Проверка 'New User Signup!'", () ->
                softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!")
        );

        var signupPage = loginPage.fillName(username)
                .fillEmail(email)
                .clickSignupBtn();

        Allure.step("Проверка 'ENTER ACCOUNT INFORMATION'", () ->
                softAssert.assertEquals(actions.getText(signupPage.enterAccountInformationHeader),
                        "ENTER ACCOUNT INFORMATION", "значения не совпадают!")
        );

        var accountCreatedPage = signupPage.fillTitle(Title.MR)
                .enterNewPassword(password)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(username)
                .fillLastName(dataService.generateRandomLastName())
                .enterCompanyName(dataService.generateRandomCompany())
                .fillAddress(dataService.generateRandomAddress())
                .fillAddress2(dataService.generateRandomAddress())
                .selectCounty("India")
                .fillState(dataService.generateRandomState())
                .fillCity(dataService.generateRandomCity())
                .fillZipcode(dataService.generateRandomZipcode())
                .fillMobileNumber(dataService.generateRandomPhoneNumber())
                .clickCreateAccountBtn();

        Allure.step("Проверка 'ACCOUNT CREATED!'", () ->
                softAssert.assertEquals(actions.getText(accountCreatedPage.accountCreatedIsVisible),
                        "ACCOUNT CREATED!", "значения не совпадают!")
        );

        var homeAfter = accountCreatedPage.clickContinueBtn();

        Allure.step("Проверка 'Logged in as ...'", () ->
                softAssert.assertEquals(actions.getText(homeAfter.loggedInAsUsernameIsVisible),
                        "Logged in as " + username, "значения не совпадают!")
        );

        homeAfter.clickLogOutBtn();
        softAssert.assertAll();

        // 4) Вернуть креды для логина
        return new User(email, password, username);
    }
}