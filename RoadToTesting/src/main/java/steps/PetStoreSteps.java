package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.requestModel.petStoreRequests.OrderRequest;
import model.requestModel.petStoreRequests.PetRequest;
import model.requestModel.petStoreRequests.UserRequest;
import model.responseModel.petStoreResponses.ApiResponse;
import model.responseModel.petStoreResponses.OrderResponse;
import model.responseModel.petStoreResponses.PetResponse;
import model.responseModel.petStoreResponses.UserResponse;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class PetStoreSteps {

    @Step
    public PetResponse postPetAdd(PetRequest pet) {
        return given().contentType(ContentType.JSON)
                .when().log().all()
                .body(pet)
                .post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).contentType(ContentType.JSON).log().all()
                .extract().response().body().as(PetResponse.class);
    }

    @Step
    public List<PetResponse> getPetsByStatus(String status) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=" + status)
                .then().log().all()
                .extract().response().body().jsonPath().getList("", PetResponse.class);
    }

    @Step
    public PetResponse getPetById(Long id) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all().extract().response().body().as(PetResponse.class);
    }

    @Step
    public ApiResponse postPetUpdate(Long id, String name, String status) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("name", name)
                .formParam("status", status)
                .when().log().all()
                .post("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all()
                .extract().response().body().as(ApiResponse.class);
    }

    @Step
    public ApiResponse deletePet(Long id) {
        return given().headers("api_key", "apiapiGOGO")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all().extract().response().body().as(ApiResponse.class);
    }


    @Step
    public OrderResponse postOrderForPurchasingPet(OrderRequest orderRequest) {
        return given().contentType(ContentType.JSON)
                .when().log().all()
                .body(orderRequest)
                .post("https://petstore.swagger.io/v2/store/order")
                .then().statusCode(200).contentType(ContentType.JSON).log().all()
                .extract().response().body().as(OrderResponse.class);
    }

    @Step
    public OrderResponse getOrderById(Integer orderId) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/store/order/" + orderId)
                .then().statusCode(200).log().all().extract().response().body().as(OrderResponse.class);
    }

    @Step
    public ApiResponse deleteOrderById(Integer orderId) {
        Assert.assertTrue(orderId > 0, "Идентификатор не может быть меньше 0");
        return given().spec(requestSpecification)
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/" + orderId)
                .then().log().all().extract().response().body().as(ApiResponse.class);
    }

    @Step
    public Map<String, Integer> getInventory() {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then().log().all().extract().response().body().jsonPath().getMap("");
    }

    @Step
    public ApiResponse postUser(UserRequest user) {
        return given().contentType(ContentType.JSON)
                .when().log().all()
                .body(user)
                .post("https://petstore.swagger.io/v2/user")
                .then().statusCode(200).contentType(ContentType.JSON).log().all()
                .extract().response().body().as(ApiResponse.class);
    }

    @Step
    public ApiResponse postArraytOfUsers(UserRequest[] users) {
        return given().contentType(ContentType.JSON)
                .when().log().all()
                .body(users)
                .post("https://petstore.swagger.io/v2/user/createWithArray")
                .then().statusCode(200).contentType(ContentType.JSON).log().all()
                .extract().response().body().as(ApiResponse.class);
    }

    @Step
    public ApiResponse postListOfUsers(List<UserRequest> users) {
        return given().contentType(ContentType.JSON)
                .when().log().all()
                .body(users)
                .post("https://petstore.swagger.io/v2/user/createWithList")
                .then().statusCode(200).contentType(ContentType.JSON).log().all()
                .extract().response().body().as(ApiResponse.class);
    }

    @Step
    public UserResponse getUserByUserName(String username) {
        return given().spec(requestSpecification)
                .when().log().all()
                .get("https://petstore.swagger.io/v2/user/" + username)
                .then().log().all().extract().response().body().as(UserResponse.class);
    }

    @Step
    public ApiResponse updateUser(UserRequest user) {
        return given().spec(requestSpecification)
                .when().log().all()
                .body(user)
                .put("https://petstore.swagger.io/v2/user/" + user.username)
                .then().log().all().extract().response().body().as(ApiResponse.class);
    }

    @Step
    public ApiResponse deleteUser(String username) {
        return given().spec(requestSpecification)
                .when().log().all()
                .delete("https://petstore.swagger.io/v2/user/" + username)
                .then().log().all()
                .extract().response().body().as(ApiResponse.class);
    }


    @Step
    public ApiResponse authUser(String username, String password) {
        return given().spec(requestSpecification)
                .when().log().all()
                .get("https://petstore.swagger.io/v2/user/login?username=" + username + "&password=" + password)
                .then().log().all()
                .extract().response().body().as(ApiResponse.class);
    }

    @Step
    public ApiResponse logoutUser() {
        return given().spec(requestSpecification)
                .when().log().all()
                .get("https://petstore.swagger.io/v2/user/logout")
                .then().log().all()
                .extract().response().body().as(ApiResponse.class);
    }
}
