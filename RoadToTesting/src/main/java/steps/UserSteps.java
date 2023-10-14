package steps;

import io.qameta.allure.Step;
import model.User;
import org.junit.Assert;
import org.testng.asserts.Assertion;
import utils.PasswordGenerator;
import utils.PhoneGenerator;
import utils.StringGenerator;

import java.util.ArrayList;
import java.util.List;

public class UserSteps {
    public static List<User> usersList = new ArrayList<>();

    @Step("добавление пользователей в список")
    public static void addUsers() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                usersList.add(new User("Danya", PasswordGenerator.generateRandomPassword(6),
                        "danya@example.com", PhoneGenerator.generatePhone()));
            }
            usersList.add(new User(StringGenerator.randomString(4),
                    PasswordGenerator.generateRandomPassword(6),
                    StringGenerator.randomString(8) + "@example.com",
                    PhoneGenerator.generatePhone()
            ));
            for (User user:usersList) {
                System.out.println(user.toString());
            }
        }
    }

    @Step("Проверка что список пользоватей не пустой")
    public static Boolean checkUsersListIsEmpty(){
        return !usersList.isEmpty();
    }

    @Step("Находим конкретного пользователя")
    public static User findUser(){
        Assert.assertTrue(checkUsersListIsEmpty());
        for (User user:usersList) {
            if(user.getLogin().equals("Danya")){
                return user;
            }
        }
        return null;
    }

    @Step("Проверяем валидность данных пользователя")
    public static void checkValidUser(){
        User user = findUser();
        assert user != null;
        String regex = "^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
        Assert.assertTrue("Невалидная почта", user.getEmail().contains("@example.com"));
        Assert.assertTrue("Невалидный телефон", user.getPhone().matches(regex));
    }
}
