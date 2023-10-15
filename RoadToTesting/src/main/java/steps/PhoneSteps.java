package steps;

import io.qameta.allure.Step;
import utils.Generator;
import utils.MyAsserts;

public class PhoneSteps {
    @Step("Генерация номера телефона")
    public static String generatePhone() {
        return Generator.generateRandomPhone();
    }

    @Step("Проверка номера телефона на соответсвие шаблону")
    public static void checkPhoneAtTemplate(String regex) {
        MyAsserts.myAssertTrue(generatePhone().matches(regex), "Номер телефона не соотвествует шаблону!");
    }
}
