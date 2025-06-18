package com.example.demo.CorsConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer config() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/")//**
                        .allowedOrigins("http://localhost:5173")  // Allow specific origin
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific methods
                        .allowedHeaders("*")  // Allow all header
                        .allowCredentials(true);  // Allow cookies and authorization headers
            }
        };
    }
}
