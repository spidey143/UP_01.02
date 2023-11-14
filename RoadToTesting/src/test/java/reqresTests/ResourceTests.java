package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.responseModel.reqresResponses.ResourceDataResponse;
import model.responseModel.reqresResponses.ResourceResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов получения ресурсов")
public class ResourceTests extends ApiBaseTest {
    @Test(testName = "GET List Resource", description = "Получение списка ресурсов")
    public static void getListResource() {
        List<ResourceDataResponse> listResources = REQRES_STEPS.getListResource(200);
       listResources.forEach(r -> Assert.assertTrue(!r.name.isEmpty() && r.id != 0));
    }

    @Test(testName = "GET Single Resource", description = "Получение ресурса")
    public static void getSingleResource() {
        ResourceResponse resource = REQRES_STEPS.getSingleResource(200);
        Assert.assertTrue(resource.data.id == 2 && resource.data.name.equals("fuchsia rose"));
    }

    @Test(testName = "GET Single Resource NOT FOUND", description = "Получение несуществующего ресурса")
    public static void getNotExistResource() {
        REQRES_STEPS.getNotExistResource(404);
    }
}
