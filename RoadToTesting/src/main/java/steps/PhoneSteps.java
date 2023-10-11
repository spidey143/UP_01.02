package steps;

import io.qameta.allure.Step;

import java.util.Random;

public class PhoneSteps {
    @Step("Генерация номера телефона")
    public static String generatePhone() {
        StringBuilder phone = new StringBuilder("+7(");
        for (int i = 0; i < 6; i++) {
            phone.append(new Random().nextInt(10));
            if (i == 2) phone.append(")");
        }
        phone.append("-");
        for (int i = 0; i < 4; i++) {
            phone.append(new Random().nextInt(10));
            if (i == 1) phone.append("-");
        }
        return phone.toString();
    }
}
