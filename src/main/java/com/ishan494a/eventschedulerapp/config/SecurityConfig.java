package com.ishan494a.eventschedulerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/auth/**").permitAll(); // Allow public access to auth endpoints
                    auth.anyRequest().authenticated(); // Secure all other requests
                })
                .oauth2Login(oauth2 -> oauth2
                        // Optionally add custom success handler or any other customization
                        .loginPage("/login") // Custom login page for OAuth2
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page for form login
                        .permitAll() // Allow access to login page
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**") // Disable CSRF for APIs if needed
                )
                .build();
    }
}
