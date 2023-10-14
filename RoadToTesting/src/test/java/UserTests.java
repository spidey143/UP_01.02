import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserSteps;

@Epic("Тесты списка пользователей")
public class UserTests {

    @BeforeClass
    public static void bfUser() {
        UserSteps.addUsers();
    }

    @Test(testName = "Проверка списка пользователей", description = "Проверка списка пользователей")
    @Description("Проверка списка пользователей")
    public static void userTestOne() {
        UserSteps.checkUsersListIsEmpty();
        UserSteps.findUser();
        UserSteps.checkValidUser();
    }
}
