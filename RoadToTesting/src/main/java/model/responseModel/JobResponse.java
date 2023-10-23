package model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponse {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
    public Date updatedAt;

    public boolean equals(JobResponse otherJobResponse){
        return name.equals(otherJobResponse.name) && job.equals(otherJobResponse.job);
    }
}
