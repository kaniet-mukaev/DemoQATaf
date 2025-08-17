package demoqa.elements;

import demoqa.BaseTest;
import org.testng.annotations.Test;

public class WebTablesPageTest extends BaseTest {

    @Test
    public void addNewEmployeeTest() {
        browserManager.open("https://demoqa.com/webtables");
        int count = 0;
        while (count < 3) {
            webTablesPage.addNewEmployee();
            count++;
        }
        webTablesPage.getAllRecordsFromWebTable().forEach(System.out::println);
    }
}
