import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserSteps;

@Epic("Тестовая группа №3")
@Feature("Тесты списка пользователей")
public class UsersListTests {

    @BeforeClass
    public static void bfUser() {
        UserSteps.addUsers();
    }

    @Test(testName = "Проверка списка пользователей", description = "Проверка списка пользователей")
    @Description("Проверка списка пользователей на всякую поебень")
    public static void usersListTestOne() {
        UserSteps.checkUsersListIsEmpty();
        User user = UserSteps.findUser("Danya");
        UserSteps.checkValidUser(user);
    }
}
