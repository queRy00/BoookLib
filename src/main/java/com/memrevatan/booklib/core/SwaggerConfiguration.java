package com.memrevatan.booklib.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.memrevatan"))
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .contact(new Contact("Muhammet Emre VATAN",
                                "https://www.linkedin.com/in/muhammetemrevatan/",
                                "muhammetemrevatan@gmail.com"))
                        .version("0.0.1 Snapshot")
                        .description("Api Documentation for BookLib")
                        .title("Api Documentation for BookLib")
                        .license("Apache 2.0")
                        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                        .build());
    }

}
