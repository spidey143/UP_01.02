import base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.requestModel.petRequest.Category;
import model.requestModel.petRequest.PetRequest;
import model.requestModel.petRequest.Tag;
import model.responseModel.PetResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PetTests extends BaseTest {

    //id = 9223372036854762914
    @Test
    public static void addPet() {
        Category category = new Category(0,"string");
        Tag tag = new Tag(0, "string");
        ArrayList<String> photoUrls =  new ArrayList<>();
        photoUrls.add("string");
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        PetRequest petRequest = new PetRequest(category,"doggie",photoUrls,tags, "available");
        PetResponse petResponse = PET_STORE_STEPS.addNewPet(petRequest);
        PET_STORE_STEPS.checkAddNewPet(petResponse);
    }

    @Test
    public void findPetsByStatus(){
        List<PetResponse> petsList = PET_STORE_STEPS.findPetsByStatus("sold");
        PET_STORE_STEPS.checkPetList(petsList);
    }
}
