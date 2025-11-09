package com.app.hospitalbilling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web Configuration class for the Hospital Billing application.
 *
 * This class configures CORS (Cross-Origin Resource Sharing) to allow
 * the Angular frontend application to communicate with the backend API.
 */
@Configuration
public class WebConfig {

    /**
     * Configure CORS to allow requests from the Angular frontend.
     *
     * This configuration allows:
     * - Requests from http://localhost:4200 (Angular dev server)
     * - All HTTP methods (GET, POST, PUT, DELETE, etc.)
     * - All headers
     * - Credentials (cookies, authorization headers)
     *
     * @return WebMvcConfigurer with CORS settings
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // Apply to all /api endpoints
                        .allowedOrigins("http://localhost:4200")  // Angular dev server
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);  // Cache preflight response for 1 hour
            }
        };
    }
}
