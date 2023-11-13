package reqresTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


@Epic("Тесты сайта reqres.in")
@Feature("Тесты запросов получения ресурсов")
public class ResourceTests extends ApiBaseTest {
    @Test(testName = "GET List Resource", description = "Получение списка ресурсов")
    public static void getListResource() {
        REQRES_STEPS.getListResource();
    }

    @Test(testName = "GET Single Resource", description = "Получение ресурса")
    public static void getSingleResource() {
        REQRES_STEPS.getSingleResource();
    }

    @Test(testName = "GET Single Resource NOT FOUND", description = "Получение несуществующего ресурса")
    public static void getNotExistResource() {
        REQRES_STEPS.getNotExistResource();
    }
}
