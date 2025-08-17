package demoqa;

import com.demoqa.data.MockDataService;
import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.BrowserManager;
import com.demoqa.helper.WebElementActions;
import com.demoqa.pages.adidas.loginUser.*;
import com.demoqa.pages.adidas.leftSideMenu.LeftSideMenu;
import com.demoqa.pages.alertsWindows.BrowserWindows;
import com.demoqa.pages.elements.*;
import com.demoqa.pages.practiceForm.PracticeFormPage;
import com.demoqa.pages.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public TextBoxPage textBoxPage;
    public MockDataService dataService;
    public WebElementActions actions;
    public SoftAssert softAssert;

    public String result(WebElement element) {
        return element.getText().substring(element.getText().indexOf(':') + 1);
    }

    public CheckBoxPage checkBoxPage;
    public WebDriverWait wait;
    public BrowserWindows browserWindows;
    public BrowserManager.WindowManager windowManager;
    public OrangeHRMLifePage orangeHRM;
    public BrowserManager browserManager;
    public BrowserManager.IframeManager iframeManager;
    public SelectMenuPage selectMenuPage;
    public Buttons buttons;
    public WebTablesPage webTablesPage;
    public PracticeFormPage practiceFormPage;
    public LeftSideMenu leftSideMenu;
    public HomePage homePage;
   public LoginPage loginPage;
    public SignUpPage signUpPage;
   public AccountCreatedPage accountCreatedPage;
    public DeleteAccountPage deleteAccount;

    @BeforeClass
    public void setupBrowser() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        dataService = new MockDataService();
        actions = new WebElementActions();
        checkBoxPage = new CheckBoxPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        browserWindows = new BrowserWindows();
        windowManager = new BrowserManager.WindowManager(driver);
        orangeHRM = new OrangeHRMLifePage();
        browserManager = new BrowserManager(driver);
        iframeManager = new BrowserManager.IframeManager(driver);
        selectMenuPage = new SelectMenuPage();
        buttons = new Buttons();
        webTablesPage = new WebTablesPage();
        practiceFormPage = new PracticeFormPage();
        leftSideMenu = new LeftSideMenu();
        homePage = new HomePage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
        accountCreatedPage = new AccountCreatedPage();
        softAssert = new SoftAssert();


    }

    public <T> T open(Class<T> clazz) {
        // 1. Открываем страницу логина
        driver.get("https://automationexercise.com/");
        // 2. Логинимся (пример — зависит от вашей реализации LoginPage)
        // 4. Открываем целевую страницу
        return PageFactory.initElements(driver, clazz);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }

    public void afterSuite() {
        System.out.println("ALL TESTS FINISHED!"); // Это сообщение появится в консоли только после завершения всех тестов
    }
}
