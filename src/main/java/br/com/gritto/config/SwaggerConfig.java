package br.com.gritto.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

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
public class SwaggerConfig {
		
	@Bean
	public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.gritto"))
                .paths(regex("/.*"))
                .build()               
				.apiInfo(metaInfo());					
	}
	
	
        
        private ApiInfo metaInfo() {

            @SuppressWarnings("rawtypes")
			ApiInfo apiInfo = new ApiInfo(
                    "Gritto API REST",
                    "API REST de cadastro de usuarios.",
                    "1.0",
                    "Terms of Service",
                    new Contact("Igor, Thomas, Jonas, Diego", "https://github.com/DiegoLeal/Gritto_Springboot",
                            "gritto@gmail.com"),
                    "Apache License Version 2.0",
                    "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>()
            );

            return apiInfo;
        }

      }	

