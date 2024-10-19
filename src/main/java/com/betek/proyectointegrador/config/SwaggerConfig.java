package com.betek.proyectointegrador.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Api REST FULL CRUD BASICO UTILIZANDO MAPS")
                .version("1.0").contact(new Contact().name("Juan Perez").url("www.linkdink.com/juanPerez")
                        .email("juan@gmailcom")).license(new License().url("www.google.com").name("Google"))
                .description("Api encargada de gestionar usuarios tipo crud usando estructura de dato tipo map"));
    }

}
