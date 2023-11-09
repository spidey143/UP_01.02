package useless;

import base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Generator;

import java.util.List;

@Epic("Тестовая группа №3")
@Feature("Тесты списка пользователей")
public class UsersListTests extends ApiBaseTest {
    public static List<User> usersList = UserListSteps.users;
    @BeforeClass
    //Добавление пользователей в список
    public static void bfUser() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                usersList.add(new User("Danya", Generator.generateRandomPassword(6),
                        "danya@example.com", Generator.generateRandomPhone()));
            }
            usersList.add(new User(Generator.generateRandomString(4),
                    Generator.generateRandomPassword(6),
                    Generator.generateRandomString(8) + "@example.com",
                    Generator.generateRandomPhone()
            ));
        }
    }

    @Test(testName = "Проверка списка пользователей", description = "Проверка списка пользователей")
    @Description("Проверка списка пользователей")
    public static void usersListTestOne() {
        USER_LIST_STEPS.checkUsersListIsEmpty();
        User user = USER_LIST_STEPS.findUser("Danya");
        USER_LIST_STEPS.checkValidUser(user);
    }

    @Test(testName = "Проверка списка пользователей", description = "Проверка списка пользователей")
    @Description("Проверка списка пользователей на всякую поебень")
    public static void usersListTestTwo() {
        USER_LIST_STEPS.checkUsersListIsEmpty();
        User user = USER_LIST_STEPS.findUser("Denis");
        USER_LIST_STEPS.checkValidUser(user);
    }
}
