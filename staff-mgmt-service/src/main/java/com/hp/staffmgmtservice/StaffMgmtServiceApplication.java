package com.hp.staffmgmtservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StaffMgmtServiceApplication {

    @Value("${server.port}")
    static int serverport1;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(StaffMgmtServiceApplication.class, args);
        System.out.println("SERVER PORT IS main " + serverport1);
    }


}
