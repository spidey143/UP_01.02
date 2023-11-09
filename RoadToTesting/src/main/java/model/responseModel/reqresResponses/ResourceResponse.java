package model.responseModel.reqresResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {
    public ResourceDataResponse data;
    public SupportResponse support;
}
