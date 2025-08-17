package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import com.demoqa.services.InvalidUserService;
import com.demoqa.entity.User;
import demoqa.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class LoginUserNegativeTest extends BaseTest {

    @Test
    @Description("Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUserWithInvalidCredentials() {
        // 1. Подготовка данных — заведомо неправильные
        User invalidUser = new InvalidUserService().generateInvalidUser();

        // 2. Запуск теста по шагам
        var loginPage = open(HomePage.class)
                .verifyPageIsLoaded()
                .clickSignupLoginBtn();

        SoftAssert softAssert = new SoftAssert();

        step("Проверка 'Login to your account' виден", () ->
                softAssert.assertEquals(actions.getText(loginPage.loginToYourAccountIsVisible),
                        "Login to your account", "Текст заголовка не совпадает!")
        );

        step("Ввод неправильного email и password", () ->
                loginPage.login(invalidUser.getEmail(), invalidUser.getPassword())
        );

        step("Проверка ошибки 'Your email or password is incorrect!'", () ->
                softAssert.assertEquals(actions.getText(loginPage.incorrectEmailOrPasswordError),
                        "Your email or password is incorrect!", "Текст ошибки не совпадает!")
        );

        softAssert.assertAll();
    }
}
