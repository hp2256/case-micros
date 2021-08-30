package com.hp.icsmgmtservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ICSMgmtServiceApplication {

	@Value("${server.port}")
	static int serverport1;

	public static void main(String[] args) {
		SpringApplication.run(ICSMgmtServiceApplication.class, args);
		System.out.println("SERVER PORT IS main "+ serverport1);
	}


}
