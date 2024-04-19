package com.yuzarsif.fordevelopers.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "google")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoogleProperties {

    private String clientId;
    private String clientSecret;
    private String apiUrl;
    private String authorizeUrl;
    private String accessTokenUrl;
    private String redirectUri;
    private String tokenUrl;
}
