package com.hp.guestsmgmtservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/*public class CorsConfig implements WebMvcConfigurer {
    @Bean
    public CorsConfig corsConfigurer() {
        return new CorsConfig() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/*")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers","Access-Control-Allow-Origin")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                        .allowCredentials(true).maxAge(36000000);

               *//*   .addMapping("/*")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "OPTIONS", "PUT")
                        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                                "Access-Control-Request-Headers","Access-Control-Allow-Origin")
                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                        .allowCredentials(true).maxAge(36000000);*//*
            }
        };
    }
}*/
public class CorsConfig {

    Logger logger = LoggerFactory.getLogger(CorsConfig.class);
    @Value("${server.port}")
    int serverport;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("SERVER PORT IS cors {}", serverport);
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
