package model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.requestModel.petRequest.Category;
import model.requestModel.petRequest.Tag;
import org.testng.annotations.Test;

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
