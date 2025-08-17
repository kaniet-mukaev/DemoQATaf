package com.demoqa.pages;

import com.demoqa.data.MockDataService;
import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.AlertHelper;
import com.demoqa.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class BasePage {
    public WebElementActions actions = new WebElementActions();
    public MockDataService dataService = new MockDataService();
    public AlertHelper alertHelper;
    public SoftAssert softAssert;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        alertHelper = new AlertHelper(DriverManager.getDriver());
        softAssert = new SoftAssert();
    }
}
