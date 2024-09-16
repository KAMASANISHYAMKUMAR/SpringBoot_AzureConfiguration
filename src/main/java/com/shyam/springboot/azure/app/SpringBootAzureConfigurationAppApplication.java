package com.shyam.springboot.azure.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "SpringBoot Application with Azure Configuration",version = "1.0"))
@SpringBootApplication
public class SpringBootAzureConfigurationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAzureConfigurationAppApplication.class, args);
	}

}
