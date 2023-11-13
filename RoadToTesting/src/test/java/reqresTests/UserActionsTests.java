package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.reqresRequests.LoginRequest;
import model.requestModel.reqresRequests.RegisterRequest;
import org.testng.annotations.Test;

@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов действия пользователя")
public class UserActionsTests extends ApiBaseTest {
    @Test(testName = "POST Register-successful", description = "Успешная регистрация пользователя")
    public static void registerSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        REQRES_STEPS.registerUser(registerRequest, 200);
    }

    @Test(testName = "POST Register-unsuccessful", description = "Провальная регистрация пользователя")
    public static void registerUnSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in");
        REQRES_STEPS.registerUser(registerRequest, 400);
    }

    @Test(testName = "POST Login-successful", description = "Успешная авторизация пользователя")
    public static void loginSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        REQRES_STEPS.loginUser(loginRequest, 200);
    }

    @Test(testName = "POST Login-unsuccessful", description = "Провальная авторизация пользователя")
    public static void loginUnSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in");
        REQRES_STEPS.loginUser(loginRequest, 400);
    }
}
