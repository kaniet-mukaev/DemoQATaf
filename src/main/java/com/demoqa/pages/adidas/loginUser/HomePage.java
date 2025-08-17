package com.demoqa.pages.adidas.loginUser;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.adidas.selections.CartPage;
import com.demoqa.pages.adidas.selections.ContactUsPage;
import com.demoqa.pages.adidas.selections.ProductsPage;
import com.demoqa.pages.adidas.selections.TestCasesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href='/' and contains(@style, 'orange')]")
    public WebElement homeOrange;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUp;

    @FindBy(xpath = "//i[@class='fa fa-lock']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAsUsernameIsVisible;

    @FindBy(xpath = "//a[@href ='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//a[normalize-space(text())='Contact us']")
    public WebElement contactUsBtn;

    @FindBy(xpath = "//a[text()=' Test Cases']")
    public WebElement testCasesBtn;

    @FindBy(xpath = "//i[@class='material-icons card_travel']")
    public WebElement productsBtn;

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    public WebElement subscriptionHeader;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    public WebElement subscribeEmailBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement subscribedAlert;

    @FindBy(xpath = "//a[@href='/view_cart']/i")
    public WebElement cart;

    @Step("click sign up btn")
    public LoginPage clickSignupLoginBtn() {
        actions.click(signUp);
        return new LoginPage();
    }

    @Step("click delete account btn")
    public DeleteAccountPage clickAccountDeleteBtn() {
        actions.click(deleteAccountButton);
        return new DeleteAccountPage();
    }

    @Step("verify home page is loaded")
    public HomePage verifyPageIsLoaded() {
        Assert.assertEquals(homeOrange.getAttribute("style"), "color: orange;");
        return this;
    }

    @Step("click Logout btn")
    public LoginPage clickLogOutBtn() {
        actions.click(logoutBtn);
        return new LoginPage();
    }

    @Step("click contact us Btn")
    public ContactUsPage clickContactUsBtn() {
        actions.click(contactUsBtn);
        return new ContactUsPage();
    }

    @Step("click Test Cases Btn")
    public TestCasesPage clickTestCasesBtn() {
        actions.click(testCasesBtn);
        return new TestCasesPage();
    }

    @Step("click Products Btn")
    public ProductsPage clickProductsBtn() {
        actions.click(productsBtn);
        return new ProductsPage();
    }

    @Step("Scroll down to footer")
    public HomePage scrollDownToFooter() {
        actions.scrollToElement(subscriptionHeader);
        return this;
    }

    @Step("Verify text SUBSCRIPTION")
    public HomePage subscriptionHeaderIsVisible() {
        Assert.assertEquals(actions.getText(subscriptionHeader), "SUBSCRIPTION", "SUBSCRIPTION текста нет");
        return this;
    }

    @Step("Enter email address in input and click arrow button")
    public HomePage enterEmailInSubscriptionInput(String email) {
        actions.type(subscribeEmailInput, email);
        actions.click(subscribeEmailBtn);
        return this;
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    public HomePage verifyThatSuccessMessageIsVisible() {
        Assert.assertTrue(subscribedAlert.isDisplayed(), "сообщение о подписке не видно");
        return this;
    }

    @Step("Click 'Cart' button")
    public CartPage clickCartPageBtn() {
        actions.click(cart);
        return new CartPage();
    }
}