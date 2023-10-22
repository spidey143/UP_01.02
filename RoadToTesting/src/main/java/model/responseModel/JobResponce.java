package model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponce {
    public String name;
    public String job;
    public String id;
    public Date createdAt;

    public boolean equals(JobResponce otherJobResponse){
        return name.equals(otherJobResponse.name) && job.equals(otherJobResponse.job);
    }
}
