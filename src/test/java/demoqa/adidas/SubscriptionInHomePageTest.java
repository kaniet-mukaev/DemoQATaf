package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class SubscriptionInHomePageTest extends BaseTest {

    @Test
    @Description("Contact Us Form")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse6")
    @Severity(SeverityLevel.BLOCKER)
    public void subscriptionInHomePageTest() {
        String email = dataService.generateRandomEmail();

        open(HomePage.class).verifyPageIsLoaded()
                .scrollDownToFooter()
                .subscriptionHeaderIsVisible()
                .enterEmailInSubscriptionInput(email)
                .verifyThatSuccessMessageIsVisible();
    }
}
