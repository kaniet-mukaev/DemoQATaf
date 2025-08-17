package demoqa.adidas;

import com.demoqa.enams.Title;
import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class LoginUserTest extends BaseTest {

    @Test
    @Description("Login User with correct data")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse2")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserWithCorrectDataTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.signUpHeaderIsVisible), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userName)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(actions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.fillTitle(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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

        step("Проверка присутствия текста ACCOUNT CREATED!", () -> {
                    softAssert.assertEquals(actions.getText(accountCreatedPage.accountCreatedIsVisible), "ACCOUNT CREATED!", "значения не совпадают!");
                }
        );

        var homePage = accountCreatedPage.clickContinueBtn();

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userName, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        homePage.clickSignupLoginBtn();


        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.loginToYourAccountIsVisible), "Login to your account", "Данные не совпадают");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userName, "значения не совпадают!");
                }
        );

        var deleteAccountPage = homePage.clickAccountDeleteBtn();

        step("Проверка присутствия текста ACCOUNT DELETED!", () -> {
                    softAssert.assertEquals(actions.getText(deleteAccountPage.accountDeletedIsVisible), "ACCOUNT DELETED!", "значения не совпадают!");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Login User with incorrect data")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse3")
    @Severity(SeverityLevel.BLOCKER)
    public void loginUserWithIncorrectDataTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.loginToYourAccountIsVisible), "Login to your account");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Your email or password is incorrect!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.incorrectEmailOrPasswordError), "Your email or password is incorrect!", "значения не совпадают!");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Logout User")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse4")
    @Severity(SeverityLevel.BLOCKER)
    public void logoutUserTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.signUpHeaderIsVisible), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userName)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(actions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.fillTitle(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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

        step("Проверка присутствия текста ACCOUNT CREATED!", () -> {
                    softAssert.assertEquals(actions.getText(accountCreatedPage.accountCreatedIsVisible), "ACCOUNT CREATED!", "значения не совпадают!");
                }
        );

        var homePage = accountCreatedPage.clickContinueBtn();

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userName, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        homePage.clickSignupLoginBtn();


        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.loginToYourAccountIsVisible), "Login to your account", "Данные не совпадают");
                }
        );

        loginPage.login(userEmail, userPassword);

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userName, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        step("Проверка присутствия текста Login to your account", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.loginToYourAccountIsVisible), "Login to your account", "Данные не совпадают");
                }
        );

        softAssert.assertAll();
    }

    @Test
    @Description("Register User with existing email")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse5")
    @Severity(SeverityLevel.BLOCKER)
    public void registerUserWithExistingEmailTest() {
        String userEmail = dataService.generateRandomEmail();
        String userPassword = dataService.generateRandomPassword();
        String userName = dataService.generateRandomFirstName();

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.signUpHeaderIsVisible), "New User Signup!");
                }
        );

        var signupPage = loginPage.fillName(userName)
                .fillEmail(userEmail)
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(actions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );

        var accountCreatedPage = signupPage.fillTitle(Title.MR)
                .enterNewPassword(userPassword)
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(userName)
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

        step("Проверка присутствия текста ACCOUNT CREATED!", () -> {
                    softAssert.assertEquals(actions.getText(accountCreatedPage.accountCreatedIsVisible), "ACCOUNT CREATED!", "значения не совпадают!");
                }
        );

        var homePage = accountCreatedPage.clickContinueBtn();

        step("Проверка присутствия текста Logged in as username", () -> {
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + userName, "значения не совпадают!");
                }
        );

        homePage.clickLogOutBtn();

        loginPage.switchToHomePage();

        homePage.clickSignupLoginBtn();


        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.signUpHeaderIsVisible), "New User Signup!");
                }
        );


        loginPage.fillName(userName)
                .fillEmail(userEmail)
                .clickSignupBtn();


        step("Проверка присутствия текста Email Address already exist!", () -> {
                    softAssert.assertEquals(actions.getText(loginPage.emailAlreadyExistError), "Email Address already exist!", "значения не совпадают!");
                }
        );

        softAssert.assertAll();
    }
}
