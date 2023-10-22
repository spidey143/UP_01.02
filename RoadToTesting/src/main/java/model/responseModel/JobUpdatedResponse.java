package model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobUpdatedResponse {
    public String name;
    public String job;
    public Date updatedAt;
}
