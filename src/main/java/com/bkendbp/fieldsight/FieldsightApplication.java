package com.bkendbp.fieldsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FieldsightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FieldsightApplication.class, args);
	}

}
