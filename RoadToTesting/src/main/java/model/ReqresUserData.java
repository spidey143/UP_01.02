package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqresUserData {
    public Integer id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
