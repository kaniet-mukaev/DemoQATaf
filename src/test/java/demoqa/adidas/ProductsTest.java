package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void productTest() {
        var productName = "Blue Top";
        open(HomePage.class)
                .verifyPageIsLoaded()
                .clickProductsBtn()
                .verifyUserIsNavigatedToProductsPage()
                .verifyProductsListIsVisible()
                .clickOnProductByName(productName)
                .verifyThatUserIsLandedToProductDetailPage(productName)
                .verifyProductDetailsAttribute();
    }
}
