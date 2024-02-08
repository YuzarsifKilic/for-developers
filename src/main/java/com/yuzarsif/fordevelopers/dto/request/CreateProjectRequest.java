package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {

    private String projectTitle;
    private String projectDescription;
    private String startDate;
    private String endDate;
    private String repositoryUrl;
    private String employeeId;
}
