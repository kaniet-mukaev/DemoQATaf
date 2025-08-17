package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class VerifyTestCasesTest extends BaseTest {

    @Test
    @Description("Verify Test Cases Page")
    @Owner("Kaniet")
    @Issue("Home work")
    @Link("https://automationexercise.com/test_cases#collapse7")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyTestCasesTest() {
        var testCasesPage = open(HomePage.class)
                .verifyPageIsLoaded()
                .clickTestCasesBtn();
        testCasesPage.verifyUserIsNavigatedToTestCasesPage();
    }
}
