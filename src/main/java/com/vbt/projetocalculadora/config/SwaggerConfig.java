package com.vbt.projetocalculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @apiNote
 * Método de configuração do Swagger
 * Para documentação da API
 * Seleciona todos os controles e paths e inicializar as configurações com Swagger 2
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vbt.projetocalculadora")) // Irá gerar documentação somente do que estiver neste packet
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "RESTful API With Spring Boot 2.1.3",
                "Project Calculadora API RESTful",
                "v1",
                "Terms Of Service Here...",
                new Contact("Vinicius Bignardi", "GitHub: github.com/bignardi", "vinicius.bignardi@outlook.com"),
                "Licence Of API",
                "License Of URL",
                Collections.emptyList());
    }

}
