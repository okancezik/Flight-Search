package com.okancezik.Flight.Search.API.business.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class BeanConfiguration {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	/*
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.okancezik.Flight.Search.API.api")) 
            .paths(PathSelectors.any())
            .build();
    }*/
}
