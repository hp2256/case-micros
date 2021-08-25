package com.hp.staffmgmtservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StaffMgmtServiceApplication {

	@Value("${server.port}")
	static int serverport1;

	public static void main(String[] args) {
		SpringApplication.run(StaffMgmtServiceApplication.class, args);
		System.out.println("SERVER PORT IS main "+ serverport1);
	}


}
