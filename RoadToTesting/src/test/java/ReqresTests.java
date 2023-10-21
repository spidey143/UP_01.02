
import base.BaseTest;
import io.restassured.http.ContentType;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.responseModel.DataResponse;
import model.responseModel.SupportResponse;
import model.responseModel.UserResponse;
import org.testng.annotations.Test;
import steps.Steps;

import java.awt.*;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ReqresTests extends BaseTest{
    @Test(description = "Проверка что аватар содержит id пользователя")
    public static void checkAvatarContainsdId() {
        System.out.println(REQRES_STEPS.getUserListConsole());
        List<ReqresUserData> userDataList = REQRES_STEPS.getUsersList();
        REQRES_STEPS.checkAvatarsContainsId(userDataList);
    }

    @Test(description = "Получить пользователя по его айди")
    public void getUserById(){
        UserResponse actualResponse = REQRES_STEPS.getUserById(2);
        DataResponse dataResponse = new DataResponse(
                2,"janet.weaver@reqres.in",
                "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        SupportResponse supportResponse = new SupportResponse(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        UserResponse expectedResponse = new UserResponse(dataResponse,supportResponse);
        REQRES_STEPS.checkUserValid(actualResponse,expectedResponse);

    }

    @Test(description = "dasdasd")
    public void createUser(){
        REQRES_STEPS.createUser();
    }
}
