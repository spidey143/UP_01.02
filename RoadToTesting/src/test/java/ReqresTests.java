import api.Specification;
import base.BaseTest;
import model.ReqresUserData;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.List;
import static io.restassured.RestAssured.given;

public class ReqresTests extends BaseTest implements Steps {
    @Test(description = "Проверка что аватар содержит id пользователя")
    public static void checkAvatarContainsdId() {
        List<ReqresUserData> users =
                given()
                        .spec(Specification.requestSpecification())
                        .get("users?page=2")
                        .then().spec(Specification.responseSpecification(200))
                        .extract().body().jsonPath().getList("data", ReqresUserData.class);
        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));

    }
}
