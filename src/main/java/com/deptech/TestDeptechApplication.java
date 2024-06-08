package com.deptech;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Test Deptech API",
				version = "1.0",
				description = "Test Deptech API"
		)
)
public class TestDeptechApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestDeptechApplication.class, args);
	}

}
