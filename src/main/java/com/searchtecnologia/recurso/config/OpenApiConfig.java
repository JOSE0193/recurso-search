package com.searchtecnologia.recurso.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Multa",
                version = "1.0",
                description = "Projeto para controle de multas"
        )
)
@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApiV1() {
        String packagesToscan[] = {"com.searchtecnologia.multa.controller.v1"};
        return GroupedOpenApi.builder()
                .group("V1")
                .displayName("Version 1")
                .packagesToScan(packagesToscan)
                .build();
    }
}