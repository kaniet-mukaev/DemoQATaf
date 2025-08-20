package com.demoqa.pages.adidas.selections;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entity.CartItem;
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

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
    private List<WebElement> cartProducts;

    public List<WebElement> addedToCartProducts() {
        return cartProducts;
    }

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

    @Step("Verify both products are added to Cart")
    public CartPage verifyAllProductsAreAddedToCart(int expectedCount) {
        Assert.assertEquals(cartProducts.size(), expectedCount, "Количество товаров в корзине не совпадает");
        return this;
    }

    public List<CartItem> getCartItems() {
        List<CartItem> items = new ArrayList<>();
        for (WebElement row : cartProducts) {
            String name = row.findElement(By.cssSelector(".cart_description a")).getText();
            int price = Integer.parseInt(row.findElement(By.cssSelector(".cart_price p"))
                    .getText().replaceAll("[^0-9]", ""));
            int quantity = Integer.parseInt(row.findElement(By.cssSelector(".cart_quantity button")).getText());
            int total = Integer.parseInt(row.findElement(By.cssSelector
                    (".cart_total_price")).getText().replaceAll("[^0-9]", ""));

            items.add(new CartItem(name, price, quantity, total));
        }
        return items;
    }

    @Step("Verify prices, quantities and total prices for products in cart")
    public CartPage verifyCartItems(List<CartItem> expectedItems) {
        List<CartItem> actualItems = getCartItems();

        Assert.assertEquals(actualItems.size(), expectedItems.size(), "Неверное количество товаров в корзине");

        for (int i = 0; i < expectedItems.size(); i++) {
            CartItem expected = expectedItems.get(i);
            CartItem actual = actualItems.get(i);

            Assert.assertEquals(actual.getPrice(), expected.getPrice(), "Цена товара " + expected.getName() + " не совпадает");
            Assert.assertEquals(actual.getQuantity(), expected.getQuantity(), "Количество товара " + expected.getName() + " не совпадает");
            Assert.assertEquals(actual.getTotal(), expected.getTotal(), "Итоговая сумма товара " + expected.getName() + " не совпадает");
        }
        return this;
    }
}
