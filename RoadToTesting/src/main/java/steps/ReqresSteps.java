package steps;

import api.Specification;
import io.qameta.allure.Step;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.requestModel.LoginRequest;
import model.requestModel.RegisterRequest;
import model.responseModel.JobResponse;
import model.responseModel.LoginResponse;
import model.responseModel.RegisterResponse;
import model.responseModel.UserResponse;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresSteps {
    @Step("Получить список пользователей в косноль")
    public String getUserListConsole() {
        return given()
                .spec(requestSpecification)
                .when()
                .get("api/users?page=2")
                .then().statusCode(200).extract().body().jsonPath().getJsonObject("data").toString();
    }

    @Step("Получаем список пользователей")
    public List<ReqresUserData> getUsersList() {
        return given().when().spec(requestSpecification)
                .get("api/users?page=2")
                .then().statusCode(200)
                .extract().body().jsonPath().getList("data", ReqresUserData.class);
    }

    @Step("Проверяем что аватар пользователя содержит его id")
    public void checkAvatarsContainsId(List<ReqresUserData> users) {
        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));
    }

    @Step
    public UserResponse getUserById(Integer id, Integer code) {
        return given()
                .when().spec(requestSpecification)
                .get("api/users/" + id)
                .then().spec(Specification.responseSpecification(code))
                .extract().response().body().as(UserResponse.class);
    }

    @Step
    public void checkUserValid(UserResponse expectedResponse, UserResponse actualResponse) {
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Step
    public void checkJobValid(JobResponse expectedResponse, JobResponse actualResponse) {
        Assert.assertTrue(expectedResponse.equals(actualResponse));
    }

    @Step
    public JobResponse createUser(JobRequest user) {
        return given().spec(requestSpecification)
                .when()
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all().extract().response().body().as(JobResponse.class);

    }

    @Step
    public void updateUser(JobRequest user, String method) {
        given().spec(requestSpecification)
                .when()
                .body(user)
                .request(method, "api/users/2")
                .then().statusCode(200).log().all().extract().response().body().as(JobResponse.class);

    }

    @Step
    public void deleteUser() {
        given().spec(requestSpecification)
                .when()
                .delete("api/users/2")
                .then().statusCode(204).log().all();

    }

    @Step
    public RegisterResponse registerUser(RegisterRequest registerRequest, Integer code) {
        return given().spec(requestSpecification)
                .when()
                .body(registerRequest)
                .post("api/register")
                .then().statusCode(code).log().all().extract().as(RegisterResponse.class);

    }

    @Step
    public void checkSuccessRegisterUser(RegisterResponse registerResponse) {
        Assert.assertTrue(registerResponse.id == 4 && registerResponse.token.equals("QpwL5tke4Pnpja7X4"));
    }

    @Step
    public void checkUnSuccessRegisterUser(RegisterResponse registerResponse) {
        Assert.assertEquals(registerResponse.error, "Missing password");
    }

    @Step
    public LoginResponse loginUser(LoginRequest loginRequest, Integer code) {
        return given().spec(requestSpecification)
                .when()
                .body(loginRequest)
                .post("api/login")
                .then().statusCode(code).log().all().extract().as(LoginResponse.class);
    }

    @Step
    public void checkSuccessLoginUser(LoginResponse loginResponse) {
        Assert.assertEquals(loginResponse.token, "QpwL5tke4Pnpja7X4");
    }

    @Step
    public void checkUnSuccessLoginUser(LoginResponse loginResponse) {
        Assert.assertEquals(loginResponse.error, "Missing password");
    }
}
