package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public final SelenideElement LOGIN_BUTTON_FORM = $x(
            "//a[@class='login_btn circle']"
    );

    public final SelenideElement INPUT_LOGIN_NAME = $x(
            "//input[@name='login_name']"
    );

    public final SelenideElement INPUT_LOGIN_PASSWORD = $x(
            "//input[@name='login_password']"
    );

    public final SelenideElement LOGIN_BUTTON = $x(
            "//input[@id='login_submit']"
    );

    public final SelenideElement EXIT_BUTTON = $x(
            "//a[text()='[Выйти]']"
    );

    public void login(String name, String password) {
        INPUT_LOGIN_NAME.setValue(name);
        INPUT_LOGIN_PASSWORD.setValue(password);
    }
}
