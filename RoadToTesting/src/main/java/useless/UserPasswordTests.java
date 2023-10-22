package useless;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Generator;

import java.util.Random;

@Epic("Тестовая группа №4")
@Feature("Тесты номера телефона пользователя")
public class UserPasswordTests extends BaseTest {
    public static User user = new User();
    @BeforeClass
    public static void bfC(){
        user.setPassword(Generator.generateRandomPassword(new Random().nextInt(5)+6));
    }

    @Test(description = "Проверка валидности пароля")
    @Description("Проверка валидности пароля")
    public static void checkPasswordIsValid(){
        System.out.println(user.getPassword());
        USER_PASSWORD_STEPS.checkPasswordLength(user.getPassword());
        USER_PASSWORD_STEPS.checkPasswordForAbc(user.getPassword());
        USER_PASSWORD_STEPS.checkPasswordForChifrec(user.getPassword());
    }

}
