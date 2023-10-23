
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.requestModel.LoginRequest;
import model.requestModel.RegisterRequest;
import model.responseModel.*;
import org.testng.annotations.Test;
import java.util.Date;
import java.util.List;

public class ReqresTests extends BaseTest{
    @Test(testName ="GET List Users", description = "Проверка что аватар содержит id пользователя")
    @Story("GET requests")
    public static void checkAvatarContainsdId() {
        System.out.println(REQRES_STEPS.getUserListConsole());
        List<ReqresUserData> userDataList = REQRES_STEPS.getUsersList();
        REQRES_STEPS.checkAvatarsContainsId(userDataList);
    }

    @Test(testName ="GET Single Users",description = "Получить пользователя по его айди")
    @Story("GET requests")
    public void getUserById() {
        UserResponse actualResponse = REQRES_STEPS.getUserById(2, 200);
        DataResponse dataResponse = new DataResponse(
                2, "janet.weaver@reqres.in",
                "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        SupportResponse supportResponse = new SupportResponse(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        UserResponse expectedResponse = new UserResponse(dataResponse, supportResponse);
        REQRES_STEPS.checkUserValid(actualResponse, expectedResponse);
    }

    @Test(testName ="GET Single Users Not Found", description = "Получение несуществующего пользователя")
    @Story("GET requests")
    public static void getNotExistUser() {
        REQRES_STEPS.getUserById(23, 404);
    }

    @Test(testName ="POST Create", description = "Создание пользователя",
            groups = "POST requests")
    @Story("POST requests")
    public void createUser(){
        JobRequest user = new JobRequest("morpheus", "leader");
        JobResponse actualResponse = REQRES_STEPS.createUser(user);
        JobResponse expectedResponse = new JobResponse(
                "morpheus","leader", "47", new Date(20000), new Date(20000));
        REQRES_STEPS.checkJobValid(expectedResponse, actualResponse);
    }

    @Test(testName ="PUT Update", description = "Обновление пользователя")
    @Story("UPDATE requests")
    @Description("Обновление пользователя c использованием PUT")
    public static void putUpdateUser(){
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "put");
    }

    @Test(testName ="PATCH Update", description = "Обновление пользователя")
    @Story("UPDATE requests")
    @Description("Обновление пользователя c использованием PATCH")
    public static void patchUpdateUser(){
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "patch");
    }

    @Test(testName ="DELETE", description = "Удаление пользователя")
    @Story("DELETE request")
    public static void deleteUser(){
        REQRES_STEPS.deleteUser();
    }

    @Test(testName ="POST Register-successful", description = "Успешная регистрация пользователя")
    @Story("POST requests")
    public static void registerSuccessful(){
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse registerResponse = REQRES_STEPS.registerUser(registerRequest, 200);
        REQRES_STEPS.checkSuccessRegisterUser(registerResponse);
    }

    @Test(testName ="POST Register-unsuccessful", description = "Провальная регистрация пользователя")
    @Story("POST requests")
    public static void registerUnSuccessful(){
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in");
        RegisterResponse registerResponse = REQRES_STEPS.registerUser(registerRequest, 400);
        REQRES_STEPS.checkUnSuccessRegisterUser(registerResponse);
    }

    @Test(testName ="POST Login-successful", description = "Успешная авторизация пользователя")
    @Story("POST requests")
    public static void loginSuccessful(){
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        LoginResponse loginResponse = REQRES_STEPS.loginUser(loginRequest, 200);
        REQRES_STEPS.checkSuccessLoginUser(loginResponse);
    }
    @Test(testName ="POST Login-unsuccessful", description = "Провальная авторизация пользователя")
    @Story("POST requests")
    public static void loginUnSuccessful(){
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in");
        LoginResponse loginResponse = REQRES_STEPS.loginUser(loginRequest, 400);
        REQRES_STEPS.checkUnSuccessLoginUser(loginResponse);
    }
}
