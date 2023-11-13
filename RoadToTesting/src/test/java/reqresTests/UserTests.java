package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.requestModel.reqresRequests.JobRequest;
import org.testng.annotations.Test;


@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов операций с пользователем")
public class UserTests extends ApiBaseTest {
    @Test(testName = "POST Create", description = "Создание пользователя")
    public void createUser() {
        JobRequest user = new JobRequest("morpheus", "leader");
        REQRES_STEPS.createUser(user);
    }

    @Test(testName = "PUT Update", description = "Обновление пользователя")
    @Description("Обновление пользователя c использованием PUT")
    public static void putUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "put");
    }

    @Test(testName = "PATCH Update", description = "Обновление пользователя")
    @Description("Обновление пользователя c использованием PATCH")
    public static void patchUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "patch");
    }

    @Test(testName = "DELETE", description = "Удаление пользователя")
    public static void deleteUser() {
        REQRES_STEPS.deleteUser();
    }
}
