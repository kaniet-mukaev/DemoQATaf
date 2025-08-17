package demoqa.elements;

import com.demoqa.pages.elements.CheckBoxPage;
import demoqa.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBoxTest extends BaseTest {

    @Test
    public void textBoxTest() {
        driver.get("https://demoqa.com/checkbox");
        actions.click(checkBoxPage.unboxingAllButton);

        List<WebElement> folders = List.of(
                checkBoxPage.home,
                checkBoxPage.desktop,
                checkBoxPage.notes,
                checkBoxPage.commands,
                checkBoxPage.documents,
                checkBoxPage.workSpace,
                checkBoxPage.react,
                checkBoxPage.angular,
                checkBoxPage.veu,
                checkBoxPage.office,
                checkBoxPage.public_,
                checkBoxPage.private_,
                checkBoxPage.classified,
                checkBoxPage.general,
                checkBoxPage.downloads,
                checkBoxPage.wordFile_doc,
                checkBoxPage.excelFile_doc);

        Map<WebElement, String> actualResultOfClicks = new HashMap<>();

//        for (WebElement folder : folders) {
//            if (checkBoxPage.home.isSelected()) {
//                actions.click(checkBoxPage.home);
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            actions.click(folder);
//            actualResultOfClicks.put(folder, checkBoxPage.results.getText());
//        }

        for (WebElement folder : folders) {
            driver.get("https://demoqa.com/checkbox");
            actions.click(checkBoxPage.unboxingAllButton);
            actions.click(folder);
            actualResultOfClicks.put(folder, checkBoxPage.results.getText());
        }

        Map<WebElement, String> expectedResultOfClicks = Map.ofEntries(
                Map.entry(checkBoxPage.home, "home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile"),
                Map.entry(checkBoxPage.desktop, "desktop notes commands"),
                Map.entry(checkBoxPage.notes, "notes"),
                Map.entry(checkBoxPage.commands, "commands"),
                Map.entry(checkBoxPage.documents, "documents workspace react angular veu office public private classified general"),
                Map.entry(checkBoxPage.workSpace, "workspace react angular veu"),
                Map.entry(checkBoxPage.react, "react"),
                Map.entry(checkBoxPage.angular, "angular"),
                Map.entry(checkBoxPage.veu, "veu"),
                Map.entry(checkBoxPage.office, "office public private classified general"),
                Map.entry(checkBoxPage.public_, "public"),
                Map.entry(checkBoxPage.private_, "private"),
                Map.entry(checkBoxPage.classified, "classified"),
                Map.entry(checkBoxPage.general, "general"),
                Map.entry(checkBoxPage.downloads, "downloads wordFile excelFile"),
                Map.entry(checkBoxPage.wordFile_doc, "wordFile"),
                Map.entry(checkBoxPage.excelFile_doc, "excelFile")
        );

        if (actualResultOfClicks.size() == 17) {
            for (Map.Entry<WebElement, String> entry : actualResultOfClicks.entrySet()) {
                WebElement folderElement = entry.getKey();

                String resultText = entry.getValue();
                String actual = resultText.replace("You have selected : ", "").trim();
                String expected = expectedResultOfClicks.get(folderElement);
                String actualNormalized = normalize(actual);
                String expectedNormalized = normalize(expected);

//                System.out.println("=== DEBUG ===");
//                System.out.println("URL: " + driver.getCurrentUrl());
//                System.out.println("HTML результата: " + checkBoxPage.results.getAttribute("outerHTML"));

                Assert.assertEquals(correct(actualNormalized).trim(), expectedNormalized, "Результаты кликов не равны: " + folderElement.getText());
            }

        }
    }

    public String correct(String element) {
        return element.substring(element.indexOf(':') + 1);
    }

    private String normalize(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
}