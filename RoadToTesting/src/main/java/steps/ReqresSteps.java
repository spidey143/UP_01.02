package steps;

import api.Specification;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.responseModel.JobUpdatedResponse;
import model.responseModel.JobResponce;
import model.responseModel.UserResponse;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresSteps {
    @Step("Получить список пользователей в косноль")
    public String getUserListConsole() {
        return given()
                .baseUri(baseURI)
                .when()
                .get("api/users?page=2")
                .then().statusCode(200).extract().body().jsonPath().getJsonObject("data").toString();
    }

    @Step("Получаем список пользователей")
    public List<ReqresUserData> getUsersList() {
        return given().when().spec(requestSpecification)
                .get("users?page=2")
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
                .get("users/" + id)
                .then().spec(Specification.responseSpecification(code))
                .extract().response().body().as(UserResponse.class);
    }

    @Step
    public void checkUserValid(UserResponse expectedResponse, UserResponse actualResponse) {
        Assert.assertEquals(actualResponse, expectedResponse);
    }

    @Step
    public void checkJobValid(JobResponce expectedResponse, JobResponce actualResponse) {
        Assert.assertTrue(expectedResponse.equals(actualResponse));
    }

    @Step
    public JobResponce createUser(JobRequest user) {
        return given().spec(requestSpecification)
                .when()
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all().extract().response().body().as(JobResponce.class);

    }

    @Step
    public void updateUser(JobRequest user, String method) {
        given().spec(requestSpecification)
                .when()
                .body(user)
                .request(method, "api/users/2")
                .then().statusCode(200).log().all().extract().response().body().as(JobUpdatedResponse.class);

    }

    @Step
    public void deleteUser() {
        given().spec(requestSpecification)
                .when()
                .delete("api/users/2")
                .then().statusCode(204).log().all();

    }
}
