package com.project.smarttaskpro.config;


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
                .csrf(csrf -> csrf.disable()) // disable CSRF for Postman testing
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").authenticated() // protect your APIs
                        .anyRequest().permitAll() // allow other requests
                )
                .httpBasic(Customizer.withDefaults()); // enable basic auth
        return http.build();
    }
}
