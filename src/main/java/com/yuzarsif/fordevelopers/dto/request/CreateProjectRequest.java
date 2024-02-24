package com.yuzarsif.fordevelopers.dto.request;

import com.yuzarsif.fordevelopers.model.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
public record CreateProjectRequest(

        @NotBlank @Size(min = 3, max = 64)
        String projectTitle,
        @NotBlank @Size(min = 3, max = 128)
        String projectDescription,
        @NotBlank @Size(min = 10, max = 10)
        String startDate,
        @NotBlank @Size(min = 10, max = 10)
        String endDate,
        @NotBlank
        String repositoryUrl,
        @NotBlank @Size(min = 32, max = 32)
        String employeeId
) {

}
