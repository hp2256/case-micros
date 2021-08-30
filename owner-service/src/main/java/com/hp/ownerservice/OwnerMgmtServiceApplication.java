package com.hp.ownerservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OwnerMgmtServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Value("${server.port}")
    static int serverport1;

    public static void main(String[] args) {
        SpringApplication.run(OwnerMgmtServiceApplication.class, args);
        System.out.println("SERVER PORT IS main " + serverport1);
    }


}
