package model.responseModel.petStoreResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseModel {
    public Integer code;
    public String type;
    public String message;
}
