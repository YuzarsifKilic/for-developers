package com.yuzarsif.fordevelopers.config;

import com.yuzarsif.fordevelopers.security.JwtAuthFilter;
import com.yuzarsif.fordevelopers.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter, UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.PUT, "/api/advertisements").hasAnyRole("COMPANY")
                        .requestMatchers(HttpMethod.POST, "/api/advertisements").hasAnyRole("COMPANY")
                        .requestMatchers(HttpMethod.DELETE, "/api/advertisements").hasAnyRole("COMPANY")
                        .requestMatchers("/api/advertisements/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/companies/**").hasAnyRole("COMPANY")
                        .requestMatchers(HttpMethod.DELETE, "/api/companies/**").hasAnyRole("COMPANY")
                        .requestMatchers("/api/companies/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/experiences").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/experiences/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/employees/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/applies").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/applies/employee/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/applies/company/**").hasAnyRole("COMPANY")
                        .requestMatchers(HttpMethod.POST, "/api/universities").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/universities/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/courses").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/courses/**").permitAll()
                        .requestMatchers("/api/locations/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/social_medias").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/social_medias/**").permitAll()
                        .requestMatchers("/api/cities/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/educations").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/educations/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/projects/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/projects/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/projects/employee/**").permitAll()
                        .requestMatchers("/auth/github/**").hasAnyRole("EMPLOYEE")
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
