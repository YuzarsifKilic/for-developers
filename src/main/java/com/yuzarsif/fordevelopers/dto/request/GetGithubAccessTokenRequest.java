package com.yuzarsif.fordevelopers.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record GetGithubAccessTokenRequest(
        @NotBlank
        String code
) {

}
