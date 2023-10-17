package steps;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import utils.Generator;
import utils.MyAsserts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPasswordSteps {
    @Step("Проверяем что пароль есть")
    public static void checkPasswordIsEmpty(String password){
        MyAsserts.myAssertTrue(password.length() >= 8, "а где пароль!");
    }

    @Step("Проверяем что пароль содержит буквы")
    public static void checkPasswordForAbc(String password){
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(password);
        MyAsserts.myAssertTrue(matcher.find(), "а где буквы!");
    }

    @Step("Проверяем что пароль содержит цифры")
    public static void checkPasswordForChifrec(String password){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);
        MyAsserts.myAssertTrue(matcher.find(), "а где цифры!");
    }
}
