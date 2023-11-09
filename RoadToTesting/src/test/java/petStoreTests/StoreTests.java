package petStoreTests;

import base.ApiBaseTest;
import model.requestModel.petStoreRequests.Category;
import model.requestModel.petStoreRequests.OrderRequest;
import model.requestModel.petStoreRequests.PetRequest;
import model.requestModel.petStoreRequests.Tag;
import model.responseModel.petStoreResponses.OrderResponse;
import model.responseModel.petStoreResponses.PetResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;

public class StoreTests extends ApiBaseTest {

    private static Long petId;
    @Test(priority = 1)
    public static void addNewPetTest() {
        Category category = new Category(0, "string");
        Tag tag = new Tag(0, "string");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        PetRequest petRequest = new PetRequest(category, "doggie-corgi-super", photoUrls, tags, "available");
        PetResponse petResponse = PET_STORE_STEPS.postPetAdd(petRequest);
        petId = petResponse.id;
        PET_STORE_STEPS.checkPetAdded(petResponse);
    }

    @Test(priority = 2)
    public void placeOrderTest() {
        OrderRequest orderRequest = new OrderRequest
                (
                        petId,
                        666,
                        "2023-11-09T09:27:01.713Z",
                        "placed",
                        true
                );
        OrderResponse orderResponse = PET_STORE_STEPS.postOrderForPurchasingPet(orderRequest);
        PET_STORE_STEPS.checkOrderPlaced(orderResponse, orderRequest.petId, orderRequest.status);
    }

}
