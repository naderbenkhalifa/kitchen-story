package tn.benkalifa.kitchenstory.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	 public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		        .apiInfo(
		            new ApiInfoBuilder()
		                .description("KitchenStory API documentation")
		                .title("KitchenStory REST API")
		                .build()
		        )
		        .groupName("REST API V1")
//		        .securityContexts(Collections.singletonList(securityContext()))
//		        .securitySchemes(Collections.singletonList(apiKey()))
		        .useDefaultResponseMessages(false)
		        .select()
		        .apis(RequestHandlerSelectors.basePackage("tn.benkalifa.kitchenstory.api.controller"))
		        .paths(PathSelectors.any())
		        .build();
		  }


}
