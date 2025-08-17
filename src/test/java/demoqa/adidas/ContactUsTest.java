package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class ContactUsTest extends BaseTest {

    @Test
    @Description("Contact Us Form")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse6")
    @Severity(SeverityLevel.BLOCKER)
    public void contactUsFormTest() {

        var contactUsPage = open(HomePage.class).verifyPageIsLoaded().clickContactUsBtn();

        SoftAssert softAssert = new SoftAssert();
        step("Проверка присутствия текста Get In Touch!", () -> {
                    softAssert.assertEquals(actions.getText(contactUsPage.getInTouchIsVisible), "GET IN TOUCH", "Get In Touch текста нет");
                }
        );

        contactUsPage.fillInputName(dataService.generateRandomFirstName())
                .fillInputEmail(dataService.generateRandomEmail())
                .fillInputSubject(dataService.generateRandomSubject())
                .fillMessage("message")
                .uploadFile("/Users/kaniet/IdeaProjects/DemoQATaf/src/main/java/com/demoqa/pages/adidas/loginUser/Umbrella_Corporation_logo.svg.png")
                .clickSubmit()
                .clickAlertAccept();

        step("Проверка присутствия текста Success! Your details have been submitted successfully.!", () -> {
                    softAssert.assertEquals(actions.getText(contactUsPage.successHeader), "Success! Your details have been submitted successfully.", "Success! Your details have been submitted successfully.");
                }
        );

        contactUsPage.clickHome().verifyPageIsLoaded();

        softAssert.assertAll();
    }
}
