package com.yuzarsif.fordevelopers.service.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class GoogleAccessTokenResponse {

    private String accessToken;
    private String tokenType;
    private String idToken;
    private int expiresIn;
    private String scope;

}
