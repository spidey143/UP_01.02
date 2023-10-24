
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.requestModel.LoginRequest;
import model.requestModel.RegisterRequest;
import model.responseModel.*;
import org.testng.annotations.Test;

public class ReqresTests extends BaseTest {

    @Test(testName = "GET List Users", description = "Проверка что аватар содержит id пользователя")
    @Story("GET requests")
    public static void getUsersList() {
        REQRES_STEPS.getUsersList();
    }

    @Test(testName = "GET Single Users", description = "Получить пользователя по его id")
    @Story("GET requests")
    public void getUserById() {
        DataResponse dataResponse = new DataResponse(
                2, "janet.weaver@reqres.in",
                "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        SupportResponse supportResponse = new SupportResponse(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        UserResponse expectedResponse = new UserResponse(dataResponse, supportResponse);
        REQRES_STEPS.getUserById(2, 200, expectedResponse);
    }

    @Test(testName = "GET Single Users NOT FOUND", description = "Получение несуществующего пользователя")
    @Story("GET requests")
    public static void getNotExistUser() {
        REQRES_STEPS.getUserById(23, 404, new UserResponse());
    }

    @Test(testName = "GET List Resource", description = "Получение списка ресурсов")
    @Story("GET requests")
    public static void getListResource() {
        REQRES_STEPS.getListResource();
    }

    @Test(testName = "GET Single Resource", description = "Получение ресурса")
    @Story("GET requests")
    public static void getSingleResource() {
        REQRES_STEPS.getSingleResource();
    }

    @Test(testName = "GET Single Resource NOT FOUND", description = "Получение несуществующего ресурса")
    @Story("GET requests")
    public static void getNotExistResource() {
        REQRES_STEPS.getNotExistResource();
    }

    @Test(testName = "POST Create", description = "Создание пользователя",
            groups = "POST requests")
    @Story("POST requests")
    public void createUser() {
        JobRequest user = new JobRequest("morpheus", "leader");
        REQRES_STEPS.createUser(user);
    }

    @Test(testName = "PUT Update", description = "Обновление пользователя")
    @Story("UPDATE requests")
    @Description("Обновление пользователя c использованием PUT")
    public static void putUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "put");
    }

    @Test(testName = "PATCH Update", description = "Обновление пользователя")
    @Story("UPDATE requests")
    @Description("Обновление пользователя c использованием PATCH")
    public static void patchUpdateUser() {
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "patch");
    }

    @Test(testName = "DELETE", description = "Удаление пользователя")
    @Story("DELETE request")
    public static void deleteUser() {
        REQRES_STEPS.deleteUser();
    }

    @Test(testName = "POST Register-successful", description = "Успешная регистрация пользователя")
    @Story("POST requests")
    public static void registerSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        REQRES_STEPS.registerUser(registerRequest, 200);
    }

    @Test(testName = "POST Register-unsuccessful", description = "Провальная регистрация пользователя")
    @Story("POST requests")
    public static void registerUnSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in");
        REQRES_STEPS.registerUser(registerRequest, 400);
    }

    @Test(testName = "POST Login-successful", description = "Успешная авторизация пользователя")
    @Story("POST requests")
    public static void loginSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        REQRES_STEPS.loginUser(loginRequest, 200);
    }

    @Test(testName = "POST Login-unsuccessful", description = "Провальная авторизация пользователя")
    @Story("POST requests")
    public static void loginUnSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in");
        REQRES_STEPS.loginUser(loginRequest, 400);
    }

    @Test(testName = "GET delayed RESPONSE", description = "Проверка что аватар содержит id пользователя")
    @Story("GET requests")
    public static void getDelayedResp() {
        REQRES_STEPS.getUsersList();
    }
}
