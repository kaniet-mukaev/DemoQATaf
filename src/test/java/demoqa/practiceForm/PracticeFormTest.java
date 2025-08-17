package demoqa.practiceForm;

import demoqa.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        browserManager.open("https://demoqa.com/automation-practice-form");
        practiceFormPage.inputFirstName();
        practiceFormPage.inputLastName();
        practiceFormPage.inputEmail();
        practiceFormPage.selectGender("Male");
        practiceFormPage.inputPhoneNumber();
        practiceFormPage.selectDateMonthYear("10 August 2025");
        practiceFormPage.inputSubjects("math");
        practiceFormPage.selectHobbies("Sports");
        practiceFormPage.selectPicture();
        practiceFormPage.inputCurrentAddress();
        practiceFormPage.selectStateAndCity();
        actions.click(practiceFormPage.submitBtn);
//        actions.click(practiceFormPage.closeResultBtn);
//        driver.findElement(By.id("sdfkjnfnfjknvkerf")).click();
    }

    @Test
    @Description("Select date of birth")
    @Owner("Kaniet")
    @Issue("Jira 123")
    @Link("www.google.com")
    @Severity(SeverityLevel.CRITICAL)
    public void dateOfBirthTest() {
        browserManager.open("https://demoqa.com/automation-practice-form");
        practiceFormPage.selectDateMonthYear("10 August 2025");
    }


}
