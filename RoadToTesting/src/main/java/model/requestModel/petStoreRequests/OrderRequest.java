package model.requestModel.petStoreRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    public Integer id;
    public Long petId;
    public Integer quantity;
    public String shipDate;
    public String status;
    public Boolean complete;
}
