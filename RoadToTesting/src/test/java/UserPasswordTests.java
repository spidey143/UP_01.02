import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserPasswordSteps;
import utils.Generator;

import java.util.Random;

@Epic("Тестовая группа №4")
@Feature("Тесты номера телефона пользователя")
public class UserPasswordTests {
    public static User user = new User();
    @BeforeClass
    public static void bfC(){
        user.setPassword(Generator.generateRandomPassword(new Random().nextInt(9)+9));
    }

    @Test(description = "Проверка валидности пароля")
    @Description("Проверка валидности пароля")
    public static void checkPasswordIsValid(){
        System.out.println(user.getPassword());
        UserPasswordSteps.checkPasswordIsEmpty(user.getPassword());
        UserPasswordSteps.checkPasswordForAbc(user.getPassword());
        UserPasswordSteps.checkPasswordForChifrec(user.getPassword());
    }

}
