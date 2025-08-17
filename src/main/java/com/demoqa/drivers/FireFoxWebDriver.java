package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxWebDriver {

    public static WebDriver loadFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--no-sendbox");
        firefoxOptions.addArguments("--window-size=1920,1080");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
