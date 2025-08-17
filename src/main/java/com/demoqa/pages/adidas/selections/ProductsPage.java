package com.demoqa.pages.adidas.selections;

import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsHeader;

    @FindBy(xpath = "//div[@class = 'features_items']/div[@class='col-sm-4']")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//p[contains(normalize-space(.), 'Category:')]")
    public WebElement category;

    @FindBy(xpath = "//span[contains(text(), 'Rs.')]")
    public WebElement price;

    @FindBy(xpath = "//b[text()='Availability:']")
    public WebElement availability;

    @FindBy(xpath = "//b[text()='Condition:']")
    public WebElement condition;

    @FindBy(xpath = "//b[text()='Brand:']")
    public WebElement brand;

    @FindBy(id = "search_product")
    public WebElement searchProductInput;

    @FindBy(id = "submit_search")
    public WebElement submitSearchBtn;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    public WebElement searchedProductsHeader;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingBtn;

    @FindBy(xpath = "//a[@href='/view_cart']/u[text()='View Cart']")
    public WebElement viewCartBtn;

    @Getter
    public static int addedToCartProductsCount;

    @Step("verify user is navigated to all products page")
    public ProductsPage verifyUserIsNavigatedToProductsPage() {
        assertTrue(allProductsHeader.isDisplayed(), "All Products не виден");
        return this;
    }

    @Step("verify products list is visible")
    public ProductsPage verifyProductsListIsVisible() {
        for (WebElement product : allProducts) {
            assertTrue(product.isDisplayed(), "Продукт не виден");
        }
        return this;
    }

    @Step("click product by name")
    public ProductsPage clickOnProductByName(String productName) {
        WebElement product = DriverManager.getDriver().findElement(By.xpath(
                "//p[text()='"+productName+"']/../following::div/ul/li/a[text()='View Product']"));
        actions.click(product);
        return this;
    }

    @Step("Verify that user is landed to product detail page")
    public ProductsPage verifyThatUserIsLandedToProductDetailPage(String productName) {
        WebElement productDetails = DriverManager.getDriver().findElement(By.xpath(
                "//div[@class='product-information']/h2[text()='"+productName+"']"));
        assertTrue(productDetails.isDisplayed(), "детали продукта не видны");
        return this;
    }

    @Step("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public ProductsPage verifyProductDetailsAttribute() {
        softAssert.assertTrue(category.isDisplayed());
        softAssert.assertTrue(price.isDisplayed());
        softAssert.assertTrue(availability.isDisplayed());
        softAssert.assertTrue(condition.isDisplayed());
        softAssert.assertTrue(brand.isDisplayed());
        softAssert.assertAll();
        return this;
    }

    @Step("Enter product name in search input and click search button")
    public ProductsPage searchProductByProductName(String productName) {
        actions.type(searchProductInput, productName);
        submitSearchBtn.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Verify that SEARCHED PRODUCTS is visible")
    public ProductsPage verifySearchedProductsHeaderIsVisible() {
        assertTrue(searchedProductsHeader.isDisplayed());
        return this;
    }

    @Step("Verify all the products related to search are visible")
    public ProductsPage verifySearchedProductsDisplayed(String searchedProductsName) {
        WebElement product = DriverManager.getDriver().findElement(By.xpath(
                "//div[@class='productinfo text-center']/p[contains(text(),'"+searchedProductsName+"')]"));
        assertTrue(product.isDisplayed());
        return this;
    }

    @Step("getProductByName")
    public WebElement getProductByName(String productName) {
        WebElement product = DriverManager.getDriver().findElement(By.xpath(
                "//div[@class='productinfo text-center']/p[contains(text(), '"+productName+"')]"));
        return product;
    }

    @Step("get product ID number")
    public int getProductIdByProductName(String productName) {
        int productIdNumber = allProducts.indexOf(getProductByName(productName)) + 1;
        return productIdNumber;
    }

    @Step("Hover over first product and click 'Add to cart'")
    public ProductsPage addProductToCardByName(String productName) {
        WebElement addToCartBtnByProductNumber = DriverManager.getDriver()
                .findElement(By.xpath(
                        "//a[@data-product-id='"
                                +getProductIdByProductName(productName)+
                                "' and @class='btn btn-default add-to-cart'])[2]"));
        actions.click(addToCartBtnByProductNumber);
        addedToCartProductsCount ++;
        return this;
    }
}
