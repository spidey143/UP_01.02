package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.reqresRequests.LoginRequest;
import model.requestModel.reqresRequests.RegisterRequest;
import model.responseModel.reqresResponses.LoginResponse;
import model.responseModel.reqresResponses.RegisterResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов действия пользователя")
public class UserActionsTests extends ApiBaseTest {
    @Test(testName = "POST Register-successful", description = "Успешная регистрация пользователя")
    public static void registerSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse registerResponse = REQRES_STEPS.registerUser(registerRequest, 200);
        Assert.assertTrue(registerResponse.id == 4 && registerResponse.token.equals("QpwL5tke4Pnpja7X4"));
    }

    @Test(testName = "POST Register-unsuccessful", description = "Провальная регистрация пользователя")
    public static void registerUnSuccessful() {
        RegisterRequest registerRequest = new RegisterRequest("eve.holt@reqres.in", null);
        RegisterResponse registerResponse = REQRES_STEPS.registerUser(registerRequest, 400);
        Assert.assertEquals(registerResponse.error, "Missing password");
    }

    @Test(testName = "POST Login-successful", description = "Успешная авторизация пользователя")
    public static void loginSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        LoginResponse loginResponse = REQRES_STEPS.loginUser(loginRequest, 200);
        Assert.assertEquals(loginResponse.token, "QpwL5tke4Pnpja7X4");
    }

    @Test(testName = "POST Login-unsuccessful", description = "Провальная авторизация пользователя")
    public static void loginUnSuccessful() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", null);
        LoginResponse loginResponse = REQRES_STEPS.loginUser(loginRequest, 400);
        Assert.assertEquals(loginResponse.error, "Missing password");
    }
}
