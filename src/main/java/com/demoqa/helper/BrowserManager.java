package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;

public class BrowserManager {

    private WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void open(final String URL) {
        driver.navigate().to(URL);    // метод navigate to сохраняет историю посещений
    }                                 // простой метод get не сохраняет

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public static class WindowManager{
        private WebDriver driver;
        private WebDriverWait wait;

        public WindowManager(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        }

        public Set<String> getWindowTabs() {   // метод берет все вкладки в браузере и сохраняет их id в сете
            return driver.getWindowHandles();
        }

        public void switchToWindow(int index) {
            LinkedList<String> windowsID = new LinkedList<>(getWindowTabs());
            if (index < 0 || index > windowsID.size()) {
                throw new IllegalArgumentException("Вы указали неправильный индекс вкладки");
            }
            driver.switchTo().window(windowsID.get(index));
        }

        public void switchToParent() {
            LinkedList<String> windowsID = new LinkedList<>(getWindowTabs());
            driver.switchTo().window(windowsID.getFirst());
        }

        public void switchToParentWithChildClose() {
            switchToParent();
            LinkedList<String> windowsID = new LinkedList<>(getWindowTabs());
            for (int i = 0; i < windowsID.size(); i++) {
                driver.switchTo().window(windowsID.get(i));
                driver.close();
            }
        }
    }

    public static class IframeManager{
        private WebDriver driver;
        private WebDriverWait webDriverWait;

        public IframeManager(WebDriver driver) {
            this.driver = driver;
            this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public IframeManager switchToFrame(WebElement element) {
            try {
                webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            return this;
        }

        public IframeManager switchToParent() {
               driver.switchTo().parentFrame();
            return this;
        }

        public IframeManager switchToFrameByIndex(int index) {
            driver.switchTo().frame(index);
            return this;
        }
    }
}
