package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Pages;
import steps.Steps;

public class UIBaseTest implements Pages, Steps {
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.screenshots = false;
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://jut.su/");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
