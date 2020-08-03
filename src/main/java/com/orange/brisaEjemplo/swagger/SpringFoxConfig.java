package com.orange.brisaEjemplo.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
  http://localhost:8080/brisa/v2/api-docs
  http://localhost:8080/brisa/swagger-ui.html
*/

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.orange.brisaEjemplo"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("REST API Brisa", "Descripcion del API", "1.0", "https://www.orange.es",
				new Contact("John Doe", "https://www.orange.es", "info@orange.es"), 
				"Licencia del API",	"http://localhost:8080/brisa/swagger-ui.html#/", Collections.emptyList());
	}
}
