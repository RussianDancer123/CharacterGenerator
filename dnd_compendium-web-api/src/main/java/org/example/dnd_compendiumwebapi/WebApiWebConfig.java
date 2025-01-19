package org.example.dnd_compendiumwebapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApiWebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/generateCharacter/**")  // Enable CORS for the /getItems endpoint
                .allowedOrigins("http://localhost:4200")  // Allow Angular frontend
                .allowedMethods("GET")
                .allowedHeaders("*");
    }
}
