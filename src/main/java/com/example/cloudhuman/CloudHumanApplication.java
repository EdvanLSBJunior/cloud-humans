package com.example.cloudhuman;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cloud Humans API", version = "1"))
public class CloudHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudHumanApplication.class, args);
	}

}
