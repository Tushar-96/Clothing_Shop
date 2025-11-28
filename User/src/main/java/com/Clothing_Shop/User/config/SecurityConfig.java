package com.Clothing_Shop.User.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/register", "/api/users/login", "/h2-console/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic().disable();
 
        // allow H2 console frames if you enable H2 later
        http.headers().frameOptions().disable();
 
        return http.build();
    }
}
 