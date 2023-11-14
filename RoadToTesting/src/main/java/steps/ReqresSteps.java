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

    @Step("Получить список ресурсов")
    public List<ResourceDataResponse> getListResource(Integer expectedStatusCode) {
        return given().when().spec(requestSpecification)
                .get("api/unknown")
                .then().statusCode(expectedStatusCode).log().all()
                .extract().body().jsonPath().getList("data", ResourceDataResponse.class);
    }

    @Step("Получить ресурс")
    public ResourceResponse getSingleResource(Integer expectedStatusCode) {
        return given().when().spec(requestSpecification)
                .get("api/unknown/2")
                .then().statusCode(expectedStatusCode).log().all()
                .extract().body().as(ResourceResponse.class);
    }

    @Step("Получить несуществующего пользователя")
    public void getNotExistResource(Integer expectedStatusCode) {
        given().when().spec(requestSpecification)
                .get("api/unknown/23")
                .then().statusCode(expectedStatusCode).log().all();
    }

    @Step("Получить пользователя по его id")
    public UserResponse getUserById(Integer id, Integer expectedStatusCode) {
        return given()
                .when().spec(requestSpecification)
                .get("api/users/" + id)
                .then().log().all().spec(Specification.responseSpecification(expectedStatusCode))
                .extract().response().body().as(UserResponse.class);
    }

    @Step("Создание пользователя")
    public JobResponse createUser(JobRequest user) {
        return given().spec(requestSpecification)
                .when()
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all().extract().response().body().as(JobResponse.class);
    }

    @Step("Обновление данных о пользователе")
    public JobResponse updateUser(JobRequest user, String method) {
        return given().spec(requestSpecification)
                .when()
                .body(user)
                .request(method, "api/users/2")
                .then().statusCode(200).log().all().extract().response().body().as(JobResponse.class);
    }

    @Step("Удалить пользователя")
    public void deleteUser(Integer expectedStatusCode) {
        given().spec(requestSpecification)
                .when()
                .delete("api/users/2")
                .then().statusCode(expectedStatusCode).log().all();
    }

    @Step("Регистрация пользователя")
    public RegisterResponse registerUser(RegisterRequest registerRequest, Integer expectedStatusCode) {
        return given().spec(requestSpecification)
                .when()
                .body(registerRequest)
                .post("api/register")
                .then().statusCode(expectedStatusCode).log().all().extract().as(RegisterResponse.class);
    }

    @Step("Авторизация пользователя")
    public LoginResponse loginUser(LoginRequest loginRequest, Integer expectedStatusCode) {
        return given().spec(requestSpecification)
                .when()
                .body(loginRequest)
                .post("api/login")
                .then().statusCode(expectedStatusCode).log().all().extract().as(LoginResponse.class);
    }
}
