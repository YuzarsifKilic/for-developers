package com.yuzarsif.fordevelopers.config;

import org.hibernate.cache.internal.DisabledCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/demo").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/demo"));

        return http
                .build();
    }
}
