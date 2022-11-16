package com.VTI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Slide05Application {

	public static void main(String[] args) {
		SpringApplication.run(Slide05Application.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfiguer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://127.0.0.1:5500/")
						.allowedMethods("GET","POST","PUT","DELETE");
			}
		};
	}
}