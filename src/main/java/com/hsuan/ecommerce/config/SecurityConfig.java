package com.hsuan.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        // Permit public access to these endpoints
//                        .antMatchers("/public/**").permitAll()
//                        // Secure other endpoints
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt
//                                // Custom JWT authentication converter (optional, used for role-based access)
//                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
//                        )
//                );
//        return http.build();
//    }
}

