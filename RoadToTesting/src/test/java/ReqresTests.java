import api.Specification;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import model.ReqresUserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ReqresTests {
    @Test
    public static void checkAvatarAndId(){
        List<ReqresUserData> users =
                given()
                        .spec(Specification.requestSpecification)
                        .get("users?page=2")
                        .then().log().all().
                        extract().body().jsonPath().getList("data", ReqresUserData.class);
        users.forEach(u -> Assert.assertTrue(u.getAvatar().contains(u.getId().toString())));

    }
}
