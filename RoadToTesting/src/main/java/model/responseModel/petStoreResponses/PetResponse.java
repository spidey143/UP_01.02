package model.responseModel.petStoreResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.requestModel.petStoreRequests.Category;
import model.requestModel.petStoreRequests.Tag;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {
    public Long id;
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;
}
