package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import utils.MyAsserts;
import utils.PhoneGenerator;

public class PhoneSteps {
    @Step("Генерация номера телефона")
    public static String generatePhone() {
        return PhoneGenerator.generatePhone();
    }

    @Step("Проверка номера телефона на соответсвие шаблону")
    public static void checkPhoneAtTemplate(String regex) {
        MyAsserts.myAssertTrue(generatePhone().matches(regex), "Номер телефона не соотвествует шаблону!");
    }
}
