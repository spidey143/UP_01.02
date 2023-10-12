package steps;

import io.qameta.allure.Step;
import utils.PhoneGenerator;

import java.util.Random;

public class PhoneSteps {
    @Step("Генерация номера телефона")
    public static String generatePhoneStep() {
        return PhoneGenerator.generatePhone();
    }
}
