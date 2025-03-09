package com.codicefiscaleapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui.html"); // Redirect automatico dalla root alla UI swagger
    }

    // Configurazione semplice per OpenAPI
    // Volendo si può personalizzare ulteriormente
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
    }
}