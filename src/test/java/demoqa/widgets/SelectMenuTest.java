package demoqa.widgets;

import demoqa.BaseTest;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest {

    @Test
    public void selectMenuTest() {
        browserManager.open("https://demoqa.com/select-menu");
        actions.selectByText(selectMenuPage.oldSelectMenu, "Purple");
        actions.selectByIndex(selectMenuPage.oldSelectMenu, 2);
        actions.selectByValue(selectMenuPage.oldSelectMenu, "10");
        actions.getAllDropdownValues(selectMenuPage.oldSelectMenu).forEach(System.out::println);
    }

    @Test
    public void selectValueAndOneMenuTest() {
        browserManager.open("https://demoqa.com/select-menu");
        selectMenuPage.selectValueByText("option 1");
        System.out.println("Select Value: " + selectMenuPage.resultOfSelectValueMenu.getText());
//        selectMenuPage.selectOneByText("Dr.");
        selectMenuPage.selectOneByText("momo");
        System.out.println("Select one: " + selectMenuPage.resultOfSelectOneMenu.getText());
    }
}
