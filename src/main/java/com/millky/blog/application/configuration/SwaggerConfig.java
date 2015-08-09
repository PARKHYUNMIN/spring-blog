package com.millky.blog.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
					// .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
					.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.build()
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBlog from Millky")
				.description("Spring Boot base Open-source Blog - APIs")
				.contact("origoni@live.com")
				.version("1.0.0")
				.build();
	}

}
