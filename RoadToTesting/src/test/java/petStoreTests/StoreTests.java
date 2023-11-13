package petStoreTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.petStoreRequests.Category;
import model.requestModel.petStoreRequests.OrderRequest;
import model.requestModel.petStoreRequests.PetRequest;
import model.requestModel.petStoreRequests.Tag;
import model.responseModel.petStoreResponses.ApiResponse;
import model.responseModel.petStoreResponses.OrderResponse;
import model.responseModel.petStoreResponses.PetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

@Epic("Тесты сайта petStore")
@Feature("Группа тестов направленная на Store")
public class StoreTests extends ApiBaseTest {

    private static Integer orderId;

    @Test(priority = 2)
    public void placeOrderTest() {
        Category category = new Category(143, "string");
        Tag tag = new Tag(0, "string");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        PetRequest petRequest = new PetRequest(category, "doggie-corgi-super", photoUrls, tags, "available");
        PetResponse petResponse = PET_STORE_STEPS.postPetAdd(petRequest);
        OrderRequest orderRequest = new OrderRequest
                (
                        5,
                        petResponse.id,
                        666,
                        "2023-11-09T09:27:01.713Z",
                        "placed",
                        true
                );
        OrderResponse orderResponse = PET_STORE_STEPS.postOrderForPurchasingPet(orderRequest);
        orderId = orderResponse.id;
        Assert.assertTrue(orderResponse.status.equals(orderRequest.status) &&
                                    orderResponse.id.equals(orderRequest.id));
    }

    @Test(priority = 3)
    public void findPurchaseOrderByIdTest() {
        OrderResponse orderResponse = PET_STORE_STEPS.getOrderById(orderId);
        Assert.assertEquals(orderResponse.id, orderId);
    }

    @Test(priority = 4)
    public void deleteOrderTest() {
        ApiResponse apiResponse = PET_STORE_STEPS.deleteOrderById(orderId);
        Assert.assertTrue(apiResponse.code == 200 && apiResponse.message.equals(orderId.toString()));
    }

    @Test(priority = 5)
    public void getPetInventoriesByStatusTest() {
        Map<String, Integer> inventory = PET_STORE_STEPS.getInventory();
        inventory.forEach((key, value) -> Assert.assertTrue(
                inventory.containsKey("sold") || inventory.containsKey("available") ||
                        inventory.containsKey("string") || inventory.containsKey("pending") ||
                        inventory.containsKey("not available")));
    }
}
