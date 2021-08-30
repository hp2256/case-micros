package com.hp.hmsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class HMSGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HMSGatewayApplication.class, args);
    }

}
