package edu.training.studentmanagementsystem.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
	@Bean
	public Docket getDocket() {
		Contact contact=new Contact("Suraj",null,"surajgpatra@gmail.com");
		List<VendorExtension> extensions=new ArrayList<>();
		
		ApiInfo apiInfo=new ApiInfo("Student Management System",
				"This is a Student Management system API "
				+"Built using Spring Boot,it is completely restful,"
				+"built using rest technology.",
				"1.0 first", "", contact,
				"", "", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("edu.training.studentmanagementsystem"))
				.build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
