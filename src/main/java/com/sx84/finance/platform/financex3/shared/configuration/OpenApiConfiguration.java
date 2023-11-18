package com.sx84.finance.platform.financex3.shared.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI carFinancePlatformOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Car Finance Platform API")
                        .description(
                                "Car Finance Platform application REST API documentation")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springqoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Car Finance platform with Documentation")
                        .url("https://car-finace-platform.wik.github.org/docs"));
    }
}
