package demoqa.adidas;

import com.demoqa.enams.Title;
import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class RegisterUserTest extends BaseTest {

    @Test
    @Description("Register User")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse1")
    @Severity(SeverityLevel.BLOCKER)
    public void registerUserTest() {

        var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста New User Signup!", () -> {
                    softAssert.assertEquals(loginPage.signUpHeaderIsVisible.getText(), "New User Signup!");
                }
        );

        var firstName = dataService.generateRandomFirstName();
        var signupPage = loginPage.fillName(firstName)
                .fillEmail(dataService.generateRandomEmail())
                .clickSignupBtn();

        step("Проверка присутствия текста Enter Account Information", () -> {
                    softAssert.assertEquals(actions.getText(signupPage.enterAccountInformationHeader), "ENTER ACCOUNT INFORMATION", "значения не совпадают!");
                }
        );



        var accountCreatedPage = signupPage.fillTitle(Title.MR)
                .enterNewPassword(dataService.generateRandomPassword())
                .selectDateMonthYearCalendar("19 March 1996")
                .clickCheckboxNewsletter()
                .clickCheckboxOption()
                .fillFirstName(firstName)
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
                    softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible), "Logged in as " + firstName, "значения не совпадают!");
                }
        );

        var deleteAccountPage = homePage.clickAccountDeleteBtn();

        step("Проверка присутствия текста ACCOUNT DELETED!", () -> {
                    softAssert.assertEquals(actions.getText(deleteAccountPage.accountDeletedIsVisible), "ACCOUNT DELETED!", "значения не совпадают!");
                }
        );

        deleteAccountPage.clickContinueBtn().verifyPageIsLoaded();

        softAssert.assertAll();
    }
}