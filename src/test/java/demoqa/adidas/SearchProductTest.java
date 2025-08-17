package demoqa.adidas;

import com.demoqa.pages.adidas.loginUser.HomePage;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {

    @Test
    public void searchProductTest() {
        var productName = "Summer White Top";
        open(HomePage.class)
                .verifyPageIsLoaded()
                .clickProductsBtn()
                .verifyUserIsNavigatedToProductsPage()
                .searchProductByProductName(productName)
                .verifySearchedProductsHeaderIsVisible()
                .verifySearchedProductsDisplayed(productName);
    }
}
