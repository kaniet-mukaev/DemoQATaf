package demoqa.adidas;

import com.demoqa.entity.CartItem;
import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AddProductsInCartTest extends BaseTest {

    @Test
    public void addProductsInCartTest() {
        var productName1 = "Blue Top";
        var productName2 = "Men Tshirt";

        List<CartItem> expected = Arrays.asList(
                new CartItem("Blue Top", 500, 1, 500),
                new CartItem("Men Tshirt", 400, 1, 400)
        );

        open(HomePage.class)
                .verifyPageIsLoaded()
                .clickProductsBtn()
                .verifyUserIsNavigatedToProductsPage()
                .verifyProductsListIsVisible()
                .addProductToCartByName(productName1)
                .clickContinueShoppingBtn()
                .addProductToCartByName(productName2)
                .clickViewCartBtn()
                .verifyAllProductsAreAddedToCart(2)
                .verifyCartItems(expected);
    }
}
