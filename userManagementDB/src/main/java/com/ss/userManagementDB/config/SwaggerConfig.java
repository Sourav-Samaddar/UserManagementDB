package com.ss.userManagementDB.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket swagConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ss.userManagementDB"))
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("User Management REST API", 
				"Documentation for User Management APP for 3rd Party", 
				"1.0", "Ters of service for using userManagementApp", 
				new Contact("Simply Sourav", "https://www.youtube.com/watch?v=vsK3LnO3tuM&list=PLq3uEqRnr_2Hb9M-hz6GPVg_x9TUQ9PJA&index=8",
						"sourav.smddr@gmail.com"), 
				"MIT License", 
				"https://www.google.com/", 
				new ArrayList<>());
	}

}
