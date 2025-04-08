package com.example.skillbridge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/css/**", "/js/**", "/img/**","/lib/**", "/scss/**","/js-admin/**").permitAll()
                .requestMatchers("/public/**").permitAll() 
                .requestMatchers("/register").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN") 
                .requestMatchers("/user/**").hasAnyRole("ClIENTE", "FREELANCER") 
                .anyRequest().authenticated() 
            )
            
            // Configure form login
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/public/home")
                .permitAll() 
            )
            
            // Configure logout
            .logout(logout -> logout
                .logoutSuccessUrl("/public/home") 
                .permitAll()
            )
            
           
            .csrf(csrf -> csrf.disable());
        
        return http.build();
    }
}