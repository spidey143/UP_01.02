package model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponce {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}
