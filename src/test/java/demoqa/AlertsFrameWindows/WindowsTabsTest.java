package demoqa.AlertsFrameWindows;

import com.demoqa.drivers.DriverManager;
import demoqa.BaseTest;
import org.testng.annotations.Test;

public class WindowsTabsTest extends BaseTest {

    @Test
    public void testWindowTab() {
        DriverManager.getDriver().get("https://demoqa.com/browser-windows");
        browserWindows.clickNewTabButton();
        browserWindows.clickNewTabButton();
        browserWindows.clickNewTabButton();
        windowManager.switchToWindow(1);
        windowManager.switchToParent();
        windowManager.switchToWindow(2);
        windowManager.switchToWindow(0);
    }
}
