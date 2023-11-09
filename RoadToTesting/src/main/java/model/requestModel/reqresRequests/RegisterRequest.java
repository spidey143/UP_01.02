package model.requestModel.reqresRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    public String email;
    public String password;

    public RegisterRequest(String email){
        this.email = email;
    }
}
