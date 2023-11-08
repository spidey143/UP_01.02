package model.requestModel.petRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetRequest {
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;

    public PetRequest(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
