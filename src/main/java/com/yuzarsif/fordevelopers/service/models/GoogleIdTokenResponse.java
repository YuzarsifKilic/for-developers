package com.yuzarsif.fordevelopers.service.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class GoogleIdTokenResponse {

    private String iss;
    private String azp;
    private String aud;
    private String sub;
    private String email;
    private boolean emailVerified;
    private String atHash;
    private String iat;
    private String exp;
    private String alg;
    private String kid;
    private String typ;
}
