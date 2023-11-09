package petStoreTests;

import base.ApiBaseTest;
import model.requestModel.petStoreRequests.Category;
import model.requestModel.petStoreRequests.PetRequest;
import model.requestModel.petStoreRequests.Tag;
import model.responseModel.petStoreResponses.ApiResponseModel;
import model.responseModel.petStoreResponses.PetResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests extends ApiBaseTest {

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

    @Test(priority = 5)
    public static void findPetsByStatusTest() {
        List<PetResponse> petsList = PET_STORE_STEPS.getPetsByStatus("sold");
        PET_STORE_STEPS.checkPetsList(petsList);
    }

    @Test(priority = 2)
    public static void findPetByIdTest() {
        PetResponse petResponse = PET_STORE_STEPS.getPetById(petId);
        PET_STORE_STEPS.checkPetWasFoundRight(petResponse,"doggie-corgi-super");
    }

    @Test(priority = 3)
    public static void updatePetWithFormDataTest() {
        ApiResponseModel response = PET_STORE_STEPS.postPetUpdate(petId,"1doggie-corgi-super1" , "sold");
        PET_STORE_STEPS.checkApiResponse(response, petId);
    }

    @Test(priority = 4)
    public static void deletePet () {
        ApiResponseModel response = PET_STORE_STEPS.deletePet(petId);
        PET_STORE_STEPS.checkApiResponse(response, petId);
    }

}
