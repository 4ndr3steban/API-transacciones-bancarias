package com.betek.proyectointegrador.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("API REST FULL SIMULADOR DE TRANSACCIONES BANCARIOAS")
                .version("1.0").contact(new Contact().name("Andres Monsalve").url("www.linkdink.com/andresmonsalvev")
                        .email("andresmonv19@gmailcom"))
                .description("Api encargada de simular transacciones bancarias basicas como crear cuentas, bolsillos y movimientos de dinero"));
    }

}
