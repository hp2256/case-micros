package com.hp.roomsmgmtservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    Logger logger = LoggerFactory.getLogger(CorsConfiguration.class);
    @Value("${server.port}")
    int serverport;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("SERVER PORT IS cors {}", serverport);
                registry.addMapping("/**").allowedOrigins("http://localhost:"+serverport);
            }
        };
    }
}