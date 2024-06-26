package com.yuzarsif.fordevelopers.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "github")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GithubProperties {

    private String apiUrl;
    private String token;
    private String authorizeUrl;
    private String accessTokenUrl;
    private String clientId;
    private String clientSecret;
    private String htmlUrl;
    private String redirectUri;
}
