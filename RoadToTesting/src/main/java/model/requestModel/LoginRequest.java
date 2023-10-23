package model.requestModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    public String email;
    public String password;

    public LoginRequest(String email){
        this.email = email;
    }
}
