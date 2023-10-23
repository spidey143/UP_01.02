package steps;

import api.Specification;
import io.qameta.allure.Step;
import model.requestModel.JobRequest;
import model.requestModel.LoginRequest;
import model.requestModel.RegisterRequest;
import model.responseModel.*;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresSteps {
    @Step
    public void getUsersList() {
        List<DataResponse> dataResponseList = given().when().spec(requestSpecification)
                .get("api/users?page=2")
                .then().statusCode(200).log().all()
                .extract().body().jsonPath().getList("data", DataResponse.class);
        dataResponseList.forEach(u -> Assert.assertTrue(u.avatar.contains(u.id.toString())));
    }

    @Step
    public void getUserById(Integer id, Integer code, UserResponse expectedUserResponse) {
        UserResponse userResponse = given()
                .when().spec(requestSpecification)
                .get("api/users/" + id)
                .then().spec(Specification.responseSpecification(code))
                .extract().response().body().as(UserResponse.class);
        Assert.assertEquals(userResponse, expectedUserResponse);
    }

    @Step
    public void createUser(JobRequest user) {
        JobResponse jobResponse = given().spec(requestSpecification)
                .when()
                .body(user)
                .post("api/users")
                .then().statusCode(201).log().all().extract().response().body().as(JobResponse.class);
        Assert.assertTrue(jobResponse.equals(new JobResponse("morpheus", "leader")));
    }

    @Step
    public void updateUser(JobRequest user, String method) {
        JobResponse jobResponse = given().spec(requestSpecification)
                .when()
                .body(user)
                .request(method, "api/users/2")
                .then().statusCode(200).log().all().extract().response().body().as(JobResponse.class);
        Assert.assertEquals(jobResponse.job, "zion resident");
    }

    @Step
    public void deleteUser() {
        given().spec(requestSpecification)
                .when()
                .delete("api/users/2")
                .then().statusCode(204).log().all();
    }

    @Step
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

    @Step
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
}
