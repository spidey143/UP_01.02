package petStoreTests;

import base.ApiBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import model.requestModel.petStoreRequests.Category;
import model.requestModel.petStoreRequests.PetRequest;
import model.requestModel.petStoreRequests.Tag;
import model.responseModel.petStoreResponses.ApiResponse;
import model.responseModel.petStoreResponses.PetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Epic("Тесты сайта petStore")
@Feature("Группа тестов направленная на Pet")
public class PetTests extends ApiBaseTest {

    private static Long petId;

    @Test(priority = 1)
    public static void addNewPetTest() {
        Category category = new Category(143, "string");
        Tag tag = new Tag(0, "string");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("string");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        PetRequest petRequest = new PetRequest(category, "doggie-corgi-super", photoUrls, tags, "available");
        PetResponse petResponse = PET_STORE_STEPS.postPetAdd(petRequest);
        petId = petResponse.id;
        Assert.assertTrue(petResponse.category.id.equals(petRequest.category.id)
                && petResponse.name.equals(petRequest.name));
    }

    @Test(priority = 5)
    public static void findPetsByStatusTest() {
        List<PetResponse> petsList = PET_STORE_STEPS.getPetsByStatus("sold");
        Assert.assertFalse(petsList.isEmpty());
        petsList.forEach(p -> Assert.assertTrue(p.id != 0 & !p.name.isEmpty()));
    }

    @Test(priority = 2)
    public static void findPetByIdTest() {
        PetResponse petResponse = PET_STORE_STEPS.getPetById(petId);
        Assert.assertEquals(petResponse.name, "doggie-corgi-super");
    }

    @Test(priority = 3)
    public static void updatePetWithFormDataTest() {
        ApiResponse response = PET_STORE_STEPS.postPetUpdate(petId,"1doggie-corgi-super1" , "sold");
        Assert.assertTrue(response.code == 200 && response.message.equals(petId.toString()));
    }

    @Test(priority = 4)
    public static void deletePet () {
        ApiResponse response = PET_STORE_STEPS.deletePet(petId);
        Assert.assertTrue(response.code == 200 && response.message.equals(petId.toString()));
    }

}
