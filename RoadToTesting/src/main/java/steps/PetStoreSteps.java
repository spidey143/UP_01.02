package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import model.requestModel.petRequest.PetRequest;
import model.responseModel.PetResponse;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class PetStoreSteps {

    @Step
    public PetResponse addNewPet(PetRequest pet) {
        return given().contentType(ContentType.JSON)
                .when()
                .body(pet)
                .post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).contentType(ContentType.JSON).log().all().extract().response().body().as(PetResponse.class);
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
                .then().log().all().extract().response().body().jsonPath().getList("", PetResponse.class);
    }

    @Step
    public void checkPetsList(List<PetResponse> petResponseList) {
        petResponseList.forEach(p -> Assert.assertTrue(p.id != 0 & !p.name.isEmpty()));
    }

    @Step
    public PetResponse getPetById(long id) {
        return given().spec(requestSpecification)
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + id)
                .then().log().all().extract().response().body().as(PetResponse.class);
    }

    @Step
    public void checkIsMyPet(PetResponse petResponse) {
        Assert.assertEquals(petResponse.name, "doggie-corgi-super");
    }

    @Step
    public void postPet(PetRequest pet) {
        given().contentType(ContentType.JSON)
              .when()
              .body(pet)
              .post("https://petstore.swagger.io/v2/pet/")
              .then().statusCode(200).contentType(ContentType.JSON).log().all().extract().response().body().as(PetResponse.class);
    }

    @Step
    public void checkPetUpdated(PetResponse pet) {
        Assert.assertTrue()
    }

}
