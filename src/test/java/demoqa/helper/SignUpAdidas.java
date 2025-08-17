//package demoqa.helper;
//
//import com.demoqa.enams.Title;
//import com.demoqa.pages.adidas.loginUserWithCorrectEmailAndPasswordTestCase.registerUserTestCase.HomePage;
//import demoqa.BaseTest;
//import lombok.Getter;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import static io.qameta.allure.Allure.step;
//
//
//
//public class SignUpAdidas extends BaseTest {
//    @Getter
//
//    private String generatedUserEmail;
//    private String generatedUserPassword;
//    private String generatedUserName;
//
//    @Test
//    public void signUpNewUser() {
//        generatedUserEmail = dataService.generateRandomEmail();
//        generatedUserPassword = dataService.generateRandomPassword();
//        generatedUserName = dataService.generateRandomFirstName();
//        SoftAssert softAssert = new SoftAssert();
//        step("регистрация", () -> {
//            var loginPage = open(HomePage.class).verifyPageIsLoaded().clickSignUp();
//            var signupPage = loginPage.fillName(generatedUserName)
//                    .fillEmail(generatedUserEmail)
//                    .clickSignupBtn();
//            var accountCreatedPage = signupPage.fillTitle(Title.MR)
//                    .enterNewPassword(generatedUserPassword)
//                    .selectDateMonthYearCalendar("19 March 1996")
//                    .clickCheckboxNewsletter()
//                    .clickCheckboxOption()
//                    .fillFirstName(generatedUserName)
//                    .fillLastName(dataService.generateRandomLastName())
//                    .enterCompanyName(dataService.generateRandomCompany())
//                    .fillAddress(dataService.generateRandomAddress())
//                    .fillAddress2(dataService.generateRandomAddress())
//                    .selectCounty("India")
//                    .fillState(dataService.generateRandomState())
//                    .fillCity(dataService.generateRandomCity())
//                    .fillZipcode(dataService.generateRandomZipcode())
//                    .fillMobileNumber(dataService.generateRandomPhoneNumber())
//                    .clickCreateAccountBtn();
//            var homePage = accountCreatedPage.clickContinueBtn();
//            homePage.clickLogOutBtn();
//            softAssert.assertEquals(actions.getText(homePage.loggedInAsUsernameIsVisible),
//                    "Logged in as " + generatedUserName, "значения не совпадают!");
//                }
//        );
//
//    }
//}
