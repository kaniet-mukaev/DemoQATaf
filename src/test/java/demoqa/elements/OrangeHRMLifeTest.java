package demoqa.elements;

import com.demoqa.helper.AlertHelper;
import com.google.j2objc.annotations.Property;
import demoqa.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMLifeTest extends BaseTest {
    public AlertHelper alertHelper;

    @Test
    @Property("2")
    public void positiveLoginTest() {
        String validUsername = "Admin";
        String validPassword = "admin123";
        browserManager.open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        orangeHRM.signIn(validUsername, validPassword);
        System.out.println("Имя пользователя: " + validUsername + "; Пароль: " + validPassword);
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
        alertHelper = new AlertHelper(driver);
        alertHelper.acceptAlertIfPresented();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        browserManager.goBack();
        browserManager.goForward();
        browserManager.refreshThePage();
    }

    @Test(invocationCount = 2)
    @Property("1")
    public void negativeLoginTest() {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            orangeHRM.signIn(dataService.generateRandomUsername(), dataService.generateRandomPassword());
            System.out.println("Имя пользователя: " + dataService.generateRandomUsername() + "; Пароль: " + dataService.generateRandomPassword());
            wait.until(ExpectedConditions.urlContains("auth/login"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"), "Ожидалось, что пользователь останется на странице логина.");
    }
}

