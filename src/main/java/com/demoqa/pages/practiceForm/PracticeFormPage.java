package com.demoqa.pages.practiceForm;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement userEmail;

    @FindBy(id = "userNumber")
    public WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(css = ".react-datepicker__month-select")
    public WebElement selectMonth;

    @FindBy(css = ".react-datepicker__year-select")
    public WebElement selectYear;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(id = "hobbies-checkbox-1")
    public WebElement sportsHobbiesInput;

    @FindBy(id = "hobbies-checkbox-2")
    public WebElement readingHobbiesInput;

    @FindBy(id = "hobbies-checkbox-3")
    public WebElement musicHobbiesInput;

    @FindBy(id = "uploadPicture")
    public WebElement selectPictureInput;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "state")
    public WebElement statesBtn;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> states;

    @FindBy(id = "city")
    public WebElement citiesBtn;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public List<WebElement> cities;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    @FindBy(id = "closeLargeModal")
    public WebElement closeResultBtn;


    public PracticeFormPage inputFirstName() {
        actions.type(firstName, dataService.generateRandomFirstName());
        return this;
    }

    public PracticeFormPage inputLastName() {
        actions.type(lastName, dataService.generateRandomLastName());
        return this;
    }

    public PracticeFormPage inputEmail() {
        actions.type(userEmail, dataService.generateRandomEmail());
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        WebElement genderRatioButton = DriverManager.getDriver().findElement(By.xpath(
                "//label[text() ='"+gender+"']"));
        actions.click(genderRatioButton);
        return this;
    }

    public PracticeFormPage inputPhoneNumber() {
        actions.type(userNumber, dataService.generateKyrgyzPhoneNumber());
        return this;
    }

    public PracticeFormPage selectDateMonthYear(String dateMothYear) {
        String[] dateMothYearParts = dateMothYear.split(" ");
        String day = dateMothYearParts[0];
        String moth = dateMothYearParts[1];
        String year = dateMothYearParts[2];
        actions.click(dateOfBirthInput);
        actions.selectByText(selectMonth, moth);
        actions.selectByText(selectYear, year);
        WebElement chooseDay = DriverManager.getDriver().findElement(By.xpath(
                "//div[contains(@class,react-datepicker__day) and " +
                        "not(contains(@class,'react-datepicker__day--outside-month')) and text()='" + day + "']"));
        actions.click(chooseDay);
        return this;
    }

    public PracticeFormPage inputSubjects(String inputSubject) {
        actions.type(subjectsInput, inputSubject);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        subjectsInput.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage selectHobbies(String hobby) {
        WebElement hobbyRatioButton = DriverManager.getDriver().findElement(By.xpath(
                "//label[text() ='"+hobby+"']"));
        actions.click(hobbyRatioButton);
        return this;
    }

    public PracticeFormPage selectPicture() {
        actions.type(selectPictureInput, "/Users/kaniet/Desktop/Screen.png");
        return this;
    }

    public PracticeFormPage inputCurrentAddress() {
        actions.type(currentAddress, dataService.generateRandomAddress());
        return this;
    }

    public PracticeFormPage selectStateAndCity() {
        Random random = new Random();
        actions.click(statesBtn);
        int state = random.nextInt(0, states.size());
        System.out.println(state);
        for (int i = 0; i < states.size(); i++) {
            actions.click(states.get(state));
        }
        actions.click(citiesBtn);
        int city = random.nextInt(0, cities.size());
        System.out.println(city);
        for (int i = 0; i < cities.size(); i++) {
            actions.click(cities.get(city));
        }
        return this;
    }
}
