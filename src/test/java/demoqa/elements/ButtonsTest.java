package demoqa.elements;

import demoqa.BaseTest;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void buttonsTest() {
        browserManager.open("https://demoqa.com/buttons");

        actions.doubleClick(buttons.doubleClickBtn);
        actions.rightClick(buttons.rightClickBtn);
        actions.click(buttons.clickMeBtn);
    }
}
