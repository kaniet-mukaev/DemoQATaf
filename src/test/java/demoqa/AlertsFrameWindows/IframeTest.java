package demoqa.AlertsFrameWindows;

import demoqa.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test
    public void iframeTest() {
        browserManager.open("https://demoqa.com/frames");
        WebElement frameElement = driver.findElement(By.id("frame1"));
        iframeManager.switchToFrame(frameElement);   // если не можем найти какой-то фрейм, то переходим на нужный фрейм
        System.out.println(driver.findElement(By.xpath("(//h1[@id='sampleHeading'])[1]")).getText());
        iframeManager.switchToParent();
        System.out.println(driver.findElement(By.xpath("//h1[text()='Frames']")).getText());
    }
}
