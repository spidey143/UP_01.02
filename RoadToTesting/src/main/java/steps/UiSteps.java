package steps;

import static com.codeborne.selenide.Condition.visible;
import static pages.Pages.HOME_PAGE;

public class UiSteps {
    public void checkLoginSuccess(){
        HOME_PAGE.EXIT_BUTTON.shouldBe(visible);
    }
}
