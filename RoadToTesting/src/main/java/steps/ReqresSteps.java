package steps;

import api.Specification;
import io.qameta.allure.Step;
import model.ReqresUserData;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    @Step("Получаем список пользователей")
    public List<ReqresUserData> getUsersList() {
        return given()
                        .spec(Specification.requestSpecification())
                        .get("users?page=2")
                        .then().spec(Specification.responseSpecification(200))
                        .extract().body().jsonPath().getList("data", ReqresUserData.class);
    }

    @Step("Проверяем что аватар пользователя содержит его id")
    public void checkAvatarsContainsId(List<ReqresUserData> users){
        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));
    }
}
