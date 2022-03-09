package com.wallmart.developer.wallmartapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author Kevin Candia
 * @date 04-03-2022
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Wallmart", license = @License(name = "Copyright © 2022 Wallmart"), description = "Busquedas de productos"))
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("PUT", "POST", "GET", "DELETE", "OPTION", "HEAD").maxAge(3600);
	}

}
