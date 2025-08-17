package demoqa.elements;

import demoqa.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.qameta.allure.Allure.step;

public class TextBoxTest extends BaseTest {

    @Test
    public void textBoxTest() {
        driver.get("https://demoqa.com/text-box");

        String randomName = dataService.generateRandomFirstName();
        String randomEmail = dataService.generateRandomEmail();
        String randomAddress = "Moskovskaya";
        String randomPermanentAddress = "Moskovskaya 101";

        textBoxPage.inputUserName("randomName")
                .inputUserEmail(randomEmail)
                .inputCurrentAddress(randomAddress)
                .inputPermanentAddress(randomPermanentAddress)
                .clickSubmit();

        //hard assertions -> если значения не совпадают , то программа дальше не идет
//        step("Проверка имени", () -> {
//                    Assert.assertEquals(result(textBoxPage.resultName), randomName, "Имена не совпадают");
//                }
//        );
//
//        step("Проверка email", () -> {
//                   Assert.assertEquals(result(textBoxPage.resultEmail), randomEmail, "Email не совпадает");
//                }
//        );
//
//        step("Проверка адреса", () -> {
//                    Assert.assertEquals(result(textBoxPage.resultCurrentAddress), randomAddress, "Адреса не совпадают");
//                }
//        );
//
//        step("Проверка адреса", () -> {
//                    Assert.assertEquals(result(textBoxPage.resultPermanentAddress), randomPermanentAddress, "Адреса не совпадают");
//                }
//        );

        //soft assert - не прерывает выполнения теста поле первого fail
        SoftAssert softAssert = new SoftAssert();
        step("Проверка имени", () -> {
                    softAssert.assertEquals(result(textBoxPage.resultName), randomName, "Имена не совпадают");
                }
        );

        step("Проверка email", () -> {
                    softAssert.assertEquals(result(textBoxPage.resultEmail), randomEmail, "Email не совпадает");
                }
        );

        step("Проверка адреса", () -> {
                    softAssert.assertEquals(result(textBoxPage.resultCurrentAddress), randomAddress, "Адреса не совпадают");
                }
        );

        step("Проверка адреса", () -> {
                    softAssert.assertEquals(result(textBoxPage.resultPermanentAddress), randomPermanentAddress, "Адреса не совпадают");
                }
        );

        //выводит все накопленные ошибки , если забудем все тесты будут зеленые
        softAssert.assertAll();
    }
}
