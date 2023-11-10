package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.requestModel.petStoreRequests.OrderRequest;
import model.requestModel.petStoreRequests.PetRequest;
import model.responseModel.petStoreResponses.ApiResponseModel;
import model.responseModel.petStoreResponses.OrderResponse;
import model.responseModel.petStoreResponses.PetResponse;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

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
    public void checkPetAdded(PetResponse petResponse) {
        Assert.assertTrue(petResponse.id != 0);
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
    public void checkPetsList(List<PetResponse> petResponseList) {
        petResponseList.forEach(p -> Assert.assertTrue(p.id != 0 & !p.name.isEmpty()));
    }

    @Step
    public PetResponse getPetById(Long id) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all().extract().response().body().as(PetResponse.class);
    }

    @Step
    public void checkPetWasFoundRight(PetResponse petResponse, String expectedName) {
        Assert.assertEquals(petResponse.name, expectedName);
    }

    @Step
    public ApiResponseModel postPetUpdate(Long id, String name, String status) {
        return given()
                .contentType(ContentType.URLENC)
                .formParam("name", "1doggie-corgi-super1")
                .formParam("status", "sold")
                .when().log().all()
                .post("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all()
                .extract().response().body().as(ApiResponseModel.class);
    }

    @Step
    public void checkApiResponse(ApiResponseModel apiResponseModel, Long id) {
        Assert.assertTrue(apiResponseModel.code == 200 && apiResponseModel.message.equals(String.valueOf(id)));
    }

    @Step
    public ApiResponseModel deletePet(Long id) {
        return given().headers("api_key", "apiapiGOGO")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all().extract().response().body().as(ApiResponseModel.class);
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
    public void checkOrderPlaced(OrderResponse orderResponse, Long petId, String status) {
        Assert.assertTrue(orderResponse.petId.equals(petId) && orderResponse.status.equals(status));
    }

    @Step
    public OrderResponse getOrderById(Integer orderId) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/store/order/"+orderId)
                .then().statusCode(200).log().all().extract().response().body().as(OrderResponse.class);
    }

    @Step
    public void checkOrderWasFoundRight(OrderResponse orderResponse, Integer petId, String status) {
        Assert.assertTrue(orderResponse.petId.equals(petId) && orderResponse.status.equals(status));
    }

}
