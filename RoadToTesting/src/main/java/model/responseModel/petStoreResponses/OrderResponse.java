package model.responseModel.petStoreResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    public Integer id;
    public Long petId;
    public Integer quantity;
    public Date shipDate;
    public String status;
    public Boolean complete;
}
