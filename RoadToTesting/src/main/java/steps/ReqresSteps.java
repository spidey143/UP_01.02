package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.responseModel.JobResponce;
import model.responseModel.UserResponse;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresSteps {

    public static final String URL = "https://reqres.in/";
    @Step("Получить список пользователей в косноль")
    public String getUserListConsole(){
        return given()
                .baseUri(URL)
                .when()
                .get("api/users?page=2")
                .then().statusCode(200).extract().body().jsonPath().getJsonObject("data").toString();
    }

    @Step("Получаем список пользователей")
    public List<ReqresUserData> getUsersList() {
        return given().when().spec(requestSpecification)
                        .get("users?page=2")
                        .then().spec(responseSpecification)
                        .extract().body().jsonPath().getList("data", ReqresUserData.class);
    }

    @Step("Проверяем что аватар пользователя содержит его id")
    public void checkAvatarsContainsId(List<ReqresUserData> users){
        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));
    }

    @Step
    public UserResponse getUserById(Integer id){
        return given()
                .when().spec(requestSpecification)
                .get("users/"+id)
                .then().spec(responseSpecification)
                .extract().response().body().as(UserResponse.class);
    }

    @Step
    public void checkUserValid(UserResponse expectedResponse, UserResponse actualResponce){
        Assert.assertEquals(actualResponce,expectedResponse);
    }

    @Step
    public void createUser(){
        given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .body(new JobRequest("morpheus", "leader"))
                .when()
                .post("users")
                .then().statusCode(201).extract().body().as(JobResponce.class);
    }
}
