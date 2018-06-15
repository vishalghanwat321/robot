package com.demo.robot.config;


/*
 *
 *  @project robot
 *
 *  @author Vishal on 14/06/18  08:30 PM
 *
 */


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_TITLE = "REST API's to consume robot services";
    private static final String API_DESCRIPTION = "ROBOT API's";
    private static final String API_VERSION = "API";
    private static final String API_TERMS_OF_SERVICE_URL = "Terms of service";
    private static final String LICENSE_OF_API = "License of API";
    private static final String API_LICENSE_URL = "Terms of service";

    private static final String API_CONTACT_ADMINISTRATOR_NAME = "Vishal Ghanwat";
    private static final String API_CONTACT_ADMINISTRATOR_BASE_URL = "/";
    private static final String API_CONTACT_ADMINISTRATOR_EMAIL_ID = "vishalghanwat321@gmail.com";


    private static final String API_BASE_PACKAGE_PATH = "com.demo.robot";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE_PATH))
                .paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(apiInfo())
                .useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET,
                        newArrayList(
                                new ResponseMessageBuilder().code(500).message("500 message")
                                        .responseModel(new ModelRef("Error")).build(),
                                new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, API_TERMS_OF_SERVICE_URL,
                new Contact(API_CONTACT_ADMINISTRATOR_NAME, API_CONTACT_ADMINISTRATOR_BASE_URL, API_CONTACT_ADMINISTRATOR_EMAIL_ID), LICENSE_OF_API,
                API_LICENSE_URL);
        return apiInfo;
    }
}
