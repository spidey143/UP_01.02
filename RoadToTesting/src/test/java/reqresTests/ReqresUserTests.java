package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.reqresRequests.JobRequest;
import model.responseModel.reqresResponses.DataResponse;
import model.responseModel.reqresResponses.JobResponse;
import model.responseModel.reqresResponses.SupportResponse;
import model.responseModel.reqresResponses.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов операций с пользователем")
public class ReqresUserTests extends ApiBaseTest {

    @Test(testName = "GET Single User", description = "Получение пользователя по его id")
    public void getUserByIdTest() {
        UserResponse actualUser = REQRES_STEPS.getUserById(2, 200);
        DataResponse dataResponse = new DataResponse(
                2, "janet.weaver@reqres.in",
                "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        SupportResponse supportResponse = new SupportResponse(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        UserResponse expectedUser = new UserResponse(dataResponse, supportResponse);
        Assert.assertEquals(actualUser, expectedUser);
    }

    @Test(testName = "POST Create", description = "Создание пользователя")
    public void createUser() {
        JobRequest user = new JobRequest("morpheus", "leader");
        JobResponse jobResponse = REQRES_STEPS.createUser(user);
        Assert.assertTrue(jobResponse.name.equals(user.name) && jobResponse.job.equals(user.job));
    }

    @Test(testName = "PUT Update", description = "Обновление пользователя")
    @Description("Обновление пользователя c использованием PUT")
    public static void putUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        JobResponse updatedJob = REQRES_STEPS.updateUser(user, "put");
        Assert.assertEquals(updatedJob.job, user.job);
    }

    @Test(testName = "PATCH Update", description = "Обновление пользователя")
    @Description("Обновление пользователя c использованием PATCH")
    public static void patchUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        JobResponse updatedJob = REQRES_STEPS.updateUser(user, "patch");
        Assert.assertEquals(updatedJob.job, user.job);
    }

    @Test(testName = "DELETE", description = "Удаление пользователя")
    public static void deleteUser() {
        REQRES_STEPS.deleteUser(204);
    }
}
