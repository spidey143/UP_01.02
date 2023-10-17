import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserListSteps;
import utils.Generator;

import java.util.List;

@Epic("Тестовая группа №3")
@Feature("Тесты списка пользователей")
public class UsersListTests {
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
    @Description("Проверка списка пользователей на всякую поебень")
    public static void usersListTestOne() {
        UserListSteps.checkUsersListIsEmpty();
        User user = UserListSteps.findUser("Danya");
        UserListSteps.checkValidUser(user);
    }

    @Test(testName = "Проверка списка пользователей", description = "Проверка списка пользователей")
    @Description("Проверка списка пользователей на всякую поебень")
    public static void usersListTestTwo() {
        UserListSteps.checkUsersListIsEmpty();
        User user = UserListSteps.findUser("Denis");
        UserListSteps.checkValidUser(user);
    }
}
