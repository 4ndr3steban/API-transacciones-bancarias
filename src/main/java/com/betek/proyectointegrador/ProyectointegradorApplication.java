package com.betek.proyectointegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectointegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectointegradorApplication.class, args);
	}

	@Configuration
	public static class CorsConfiguration{

		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedOrigins("*")
							.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS");
				}
			};
		}
	}
}
