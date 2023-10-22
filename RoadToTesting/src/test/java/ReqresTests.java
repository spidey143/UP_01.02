
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.ReqresUserData;
import model.requestModel.JobRequest;
import model.responseModel.DataResponse;
import model.responseModel.JobResponce;
import model.responseModel.SupportResponse;
import model.responseModel.UserResponse;
import org.testng.annotations.Test;
import steps.Steps;

import java.awt.*;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresTests extends BaseTest{
    @Test(testName ="GET List Users", description = "Проверка что аватар содержит id пользователя")
    public static void checkAvatarContainsdId() {
        System.out.println(REQRES_STEPS.getUserListConsole());
        List<ReqresUserData> userDataList = REQRES_STEPS.getUsersList();
        REQRES_STEPS.checkAvatarsContainsId(userDataList);
    }

    @Test(testName ="GET Single Users",description = "Получить пользователя по его айди")
    public void getUserById() {
        UserResponse actualResponse = REQRES_STEPS.getUserById(2, 200);
        DataResponse dataResponse = new DataResponse(
                2, "janet.weaver@reqres.in",
                "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg");
        SupportResponse supportResponse = new SupportResponse(
                "https://reqres.in/#support-heading",
                "To keep ReqRes free, contributions towards server costs are appreciated!");
        UserResponse expectedResponse = new UserResponse(dataResponse, supportResponse);
        REQRES_STEPS.checkUserValid(actualResponse, expectedResponse);
    }

    @Test(testName ="GET Single Users Not Found", description = "Получение несуществующего пользователя")
    public static void getNotExistUser() {
        REQRES_STEPS.getUserById(23, 404);
    }

    @Test(testName ="POST Create", description = "Создание пользователя")
    public void createUser(){
        JobRequest user = new JobRequest("morpheus", "leader");
        JobResponce actualResponse = REQRES_STEPS.createUser(user);
        JobResponce expectedResponse = new JobResponce("morpheus","leader", "47", new Date(20000));
        REQRES_STEPS.checkJobValid(expectedResponse, actualResponse);
    }

    @Test(testName ="PUT Update", description = "Обновление пользователя")
    public static void putUpdateUser(){
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "put");
    }

    @Test(testName ="PATCH Update", description = "Обновление пользователя")
    public static void patchUpdateUser(){
        JobRequest user = new JobRequest("morpheus", "zion resident");
        REQRES_STEPS.updateUser(user, "patch");
    }

    @Test(testName ="DELETE", description = "Обновление пользователя")
    public static void deleteUser(){
        REQRES_STEPS.deleteUser();
    }
}
