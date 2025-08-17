package com.demoqa.pages.adidas.selections;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.adidas.loginUser.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    public WebElement subscriptionHeader;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    public WebElement subscribeEmailBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    public WebElement subscribedAlert;

    @Step("Scroll down to footer")
    public CartPage scrollDownToFooter() {
        actions.scrollToElement(subscriptionHeader);
        return this;
    }

    @Step("Verify text SUBSCRIPTION")
    public CartPage subscriptionHeaderIsVisible() {
        Assert.assertEquals(actions.getText(subscriptionHeader), "SUBSCRIPTION", "SUBSCRIPTION текста нет");
        return this;
    }

    @Step("Enter email address in input and click arrow button")
    public CartPage enterEmailInSubscriptionInput(String email) {
        actions.type(subscribeEmailInput, email);
        actions.click(subscribeEmailBtn);
        return this;
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    public CartPage verifyThatSuccessMessageIsVisible() {
        Assert.assertTrue(subscribedAlert.isDisplayed(), "сообщение о подписке не видно");
        return this;
    }

    public List<WebElement> addedToCartProducts() {
        List<WebElement> addedProducts = new ArrayList<>();
        for (int i = 1; i < ProductsPage.getAddedToCartProductsCount(); i++) {
            WebElement product = DriverManager.getDriver().findElement(By.id("product-" + i));
            addedProducts.add(product);
        }
        return addedProducts;
    }

    @Step("Verify both products are added to Cart")
    public CartPage verifyAllProductsAreAddedToCart(int addedProductsCount) {
        int actualCount = 0;
        List<WebElement> products = new ArrayList<>(addedToCartProducts());
        for (WebElement element : products) {
            if (element != null) {
                actualCount++;
            }
        }
        Assert.assertEquals(actualCount, ProductsPage.getAddedToCartProductsCount());
        return this;
    }
}
