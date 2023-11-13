package uiTests;

import base.UIBaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.UiSteps;

public class UITests extends UIBaseTest {

    @Test
    public void testSomething() {
        HOME_PAGE.LOGIN_BUTTON_FORM.click();
        HOME_PAGE.login("danyaDanyaDaNYa", "EYLSir+Ei8!kmnX");
        HOME_PAGE.LOGIN_BUTTON.click();
        UI_STEPS.checkLoginSuccess();
    }
}
