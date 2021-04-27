package com.vbt.projetocalculadora.config;

import com.vbt.projetocalculadora.converters.serialization.YamlHttpConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @apiNote
 * Implantando Content Negotiation
 * Para que as requisições possa solicitar arquivos JSON e XML
 */

@Configuration
// @EnableWebMvc -> Pode apresentar problemas de serialização do Jackson
public class WebConfig implements WebMvcConfigurer {

    // Media Type para tipo YAML
    private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

    // Sobrecarga do método conversor YamlHttpConverter
    public void extendMessageYamlHttpConverter(List<HttpMessageConverter<?>> converter) {
        converter.add(new YamlHttpConverter());
    }

    // CORS adicionado globalmente.
    // Por padrão, os métodos GET, POST, PUT e DELETE funcionam bem, para os demais é necessário o uso do allowedMethods() para declará-los
    public void addCorsMapping(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

//        // Content Negotiation via EXTENSION
//        // Ex: /api/person/v3/3.xml
//        configurer.favorParameter(false)
//                .ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)
//                .mediaType("x-yaml", MEDIA_TYPE_YAML);


//        // Content Negotiation via QUERY Parameter
//        // Ex: /api/person/v3/3?mediaType=xml
//        configurer.favorPathExtension(false)
//                .favorParameter(true)
//                .parameterName("mediaType")
//                .ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)
//                .mediaType("x-yaml", MEDIA_TYPE_YAML);


        // Content Negotiation via HEADER Parameter
        // Passar o parâmetro no Header -> Accept + application/json
        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_YAML);
    }

}
