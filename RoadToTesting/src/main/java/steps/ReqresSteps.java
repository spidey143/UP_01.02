package steps;

import api.Specification;
import io.qameta.allure.Step;
import model.requestModel.reqresRequests.JobRequest;
import model.requestModel.reqresRequests.LoginRequest;
import model.requestModel.reqresRequests.RegisterRequest;
import model.responseModel.reqresResponses.*;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresSteps {
    @Step("Получить список пользователей")
    public void getUsersList() {
        List<DataResponse> dataResponseList = given().when().spec(requestSpecification)
                .get("api/users?page=2")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", DataResponse.class);
        dataResponseList.forEach(u -> Assert.assertTrue(u.avatar.contains(u.id.toString())));
    }

    @Step("Получить список ресурсов")
    public void getListResource() {
         given().when().spec(requestSpecification)
                .get("api/unknown")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", ResourceDataResponse.class);
    }

    @Step("Получить ресурс")
    public void getSingleResource() {
        given().when().spec(requestSpecification)
                .get("api/unknown/2")
                .then().statusCode(200).log().all()
                .extract().body().as(ResourceResponse.class);
    }

    @Step("Получить несуществующего пользователя")
    public void getNotExistResource() {
        given().when().spec(requestSpecification)
                .get("api/unknown/23")
                .then().statusCode(404).log().all();
    }

    @Step("Получить пользователя по его id")
    public void getUserById(Integer id, Integer code, UserResponse expectedUserResponse) {
        UserResponse userResponse = given()
                .when().spec(requestSpecification)
                .get("api/users/" + id)
                .then().log().all().spec(Specification.responseSpecification(code))
                .extract().response().body().as(UserResponse.class);
        Assert.assertEquals(userResponse, expectedUserResponse);
    }

    @Step("Создание пользователя")
    public void createUser(JobRequest user) {
        JobResponse jobResponse = given().spec(requestSpecification)
                .when()
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all().extract().response().body().as(JobResponse.class);
        Assert.assertTrue(jobResponse.equals(new JobResponse("morpheus", "leader")));
    }

    @Step("Обновление данных о пользователе")
    public void updateUser(JobRequest user, String method) {
        JobResponse jobResponse = given().spec(requestSpecification)
                .when()
                .body(user)
                .request(method, "api/users/2")
                .then().statusCode(200).log().all().extract().response().body().as(JobResponse.class);
        Assert.assertEquals(jobResponse.job, "zion resident");
    }

    @Step("Удалить пользователя")
    public void deleteUser() {
        given().spec(requestSpecification)
                .when()
                .delete("api/users/2")
                .then().statusCode(204).log().all();
    }

    @Step("Регистрация пользователя")
    public void registerUser(RegisterRequest registerRequest, Integer code) {
        RegisterResponse registerResponse = given().spec(requestSpecification)
                .when()
                .body(registerRequest)
                .post("api/register")
                .then().statusCode(code).log().all().extract().as(RegisterResponse.class);
        if (registerResponse.error == null)
            Assert.assertTrue(registerResponse.id == 4 && registerResponse.token.equals("QpwL5tke4Pnpja7X4"));
        else Assert.assertEquals(registerResponse.error, "Missing password");
    }

    @Step("Авторизация пользователя")
    public void loginUser(LoginRequest loginRequest, Integer code) {
        LoginResponse loginResponse = given().spec(requestSpecification)
                .when()
                .body(loginRequest)
                .post("api/login")
                .then().statusCode(code).log().all().extract().as(LoginResponse.class);
        if (loginResponse.error == null)
            Assert.assertEquals(loginResponse.token, "QpwL5tke4Pnpja7X4");
        else Assert.assertEquals(loginResponse.error, "Missing password");
    }

    @Step("Получить отложенный список пользователей")
    public void getDelayUserList() {
        List<DataResponse> dataResponseList = given().when().spec(requestSpecification)
                .get("api/users?delay=3")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", DataResponse.class);
        dataResponseList.forEach(u -> Assert.assertTrue(u.avatar.contains(u.id.toString())));
    }
}
