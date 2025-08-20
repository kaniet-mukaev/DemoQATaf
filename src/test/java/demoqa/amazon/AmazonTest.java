package demoqa.amazon;

import demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest extends BaseTest {

    @Test
    public void amazonTest() {

        browserManager.open("https://www.amazon.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        actions.typeWithEnter(searchInput, "iphone");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-component-type='s-search-result']"))
        );

        // Получаем все доступные бренды автоматически
        List<String> availableBrands = getAllAvailableBrands();
        System.out.println("Найдено брендов: " + availableBrands.size());
        System.out.println("Доступные бренды: " + availableBrands);

        // Кликаем по всем найденным брендам
        for (String brand : availableBrands) {
            selectBrand(brand);
        }
    }

//    private List<String> getAllAvailableBrands() {                       //РАБОЧИЙ ВАРИАНТ 1
//        List<String> brands = new ArrayList<>();
//        try {
//            // Сначала раскрываем полный список брендов
//            ensureBrandsExpanded();
//
//            // Ждем подгрузки брендов
//            Thread.sleep(2000);
//
//            // Ищем все элементы брендов
//            By brandLocator = By.xpath(
//                    "//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'] | " +
//                            "//div[@id='brandsRefinements']//span[contains(@class, 'a-size-base')]"
//            );
//
//            List<WebElement> brandElements = wait.until(
//                    ExpectedConditions.visibilityOfAllElementsLocatedBy(brandLocator)
//            );
//
//            // Собираем названия брендов, исключая заголовки
//            for (WebElement brandElement : brandElements) {
//                String brandName = brandElement.getText().trim();
//
//                // Исключаем заголовки и пустые строки
//                if (!brandName.isEmpty() &&
//                        !brandName.equalsIgnoreCase("Brands") &&
//                        !brandName.equalsIgnoreCase("Featured Brands") &&
//                        !brands.contains(brandName)) {
//                    brands.add(brandName);
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("Ошибка при получении списка брендов: " + e.getMessage());
//        }
//        return brands;
//    }

    private List<String> getAllAvailableBrands() {                 //РАБОЧИЙ ВАРИАНТ 2
        List<String> brands = new ArrayList<>();
        try {
            ensureBrandsExpanded();
            Thread.sleep(2000);

            By brandLocator = By.xpath(
                    "//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'] | " +
                            "//div[@id='brandsRefinements']//span[contains(@class, 'a-size-base')]"
            );

            List<WebElement> brandElements = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(brandLocator)
            );

            for (WebElement brandElement : brandElements) {
                String brandName = brandElement.getText().trim();
                // Исключаем только заголовок "Brands"
                if (!brandName.isEmpty() && !brandName.equals("Brands") && !brands.contains(brandName)) {
                    brands.add(brandName);
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка при получении списка брендов: " + e.getMessage());
        }
        return brands;
    }

    private void selectBrand(String brandName) {
        try {
            // Улучшенный локатор
            By brandLocator = By.xpath(
                    "//div[@id='brandsRefinements']//span[text()='" + brandName + "']/ancestor::a | " +
                            "//div[@id='brandsRefinements']//span[text()='" + brandName + "']/ancestor::div[contains(@class, 'checkbox')] | " +
                            "//div[@id='brandsRefinements']//span[text()='" + brandName + "']/.."
            );

            List<WebElement> elements = driver.findElements(brandLocator);

            if (elements.isEmpty()) {
                System.out.println("Бренд " + brandName + " не найден для клика");
                return;
            }

            // Прокручиваем и кликаем
            WebElement brandElement = elements.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandElement);
            Thread.sleep(500);

            brandElement = wait.until(ExpectedConditions.elementToBeClickable(brandLocator));
            System.out.println("Выбираем бренд: " + brandName);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", brandElement);

            // Ожидание обновления
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".s-loading-spinner, .s-loading-image")
            ));

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("[data-component-type='s-search-result']")
            ));

            System.out.println("Фильтр применён: " + brandName);
            Thread.sleep(1500);

        } catch (Exception e) {
            System.out.println("Ошибка при выборе бренда " + brandName);
        }
    }

    private void ensureBrandsExpanded() {
        try {
            By seeMoreLocator = By.xpath(
                    "//div[@id='brandsRefinements']//span[contains(text(), 'See more')] | " +
                            "//div[@id='brandsRefinements']//a[contains(text(), 'See more')]"
            );

            List<WebElement> seeMoreButtons = driver.findElements(seeMoreLocator);
            if (!seeMoreButtons.isEmpty()) {
                WebElement seeMoreButton = seeMoreButtons.get(0);
                if (seeMoreButton.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeMoreButton);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seeMoreButton);
                    Thread.sleep(2000); // Даем время на подгрузку
                }
            }
        } catch (Exception e) {
            // Кнопка может отсутствовать
        }
    }
}
