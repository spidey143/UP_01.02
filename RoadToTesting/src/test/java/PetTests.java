import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.requestModel.petRequest.Category;
import model.requestModel.petRequest.PetRequest;
import model.requestModel.petRequest.Tag;
import model.responseModel.ApiResponseModel;
import model.responseModel.PetResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests extends BaseTest {

    private static Long petId;

    @Test
    public static void addNewPetToPetStoreTest() {
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

    @Test
    public static void findPetsByStatusTest() {
        List<PetResponse> petsList = PET_STORE_STEPS.getPetsByStatus("sold");
        PET_STORE_STEPS.checkPetsList(petsList);
    }

    @Test
    public static void findPetByIdTest() {
        PetResponse petResponse = PET_STORE_STEPS.getPetById(petId);
        PET_STORE_STEPS.checkPetWasFoundRight(petResponse,"doggie-corgi-super");
    }

    @Test
    public void updatePetTest() {
        ApiResponseModel response = PET_STORE_STEPS.postPetUpdate(petId,"1doggie-corgi-super1" , "sold");
        PET_STORE_STEPS.checkPetUpdated(response, petId);
    }
}
