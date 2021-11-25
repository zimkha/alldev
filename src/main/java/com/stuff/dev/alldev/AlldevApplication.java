package com.stuff.dev.alldev;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class AlldevApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlldevApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList(
				"Origin",
				"Access-Control-Allow-Origin",
				"Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Request-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"
		) );
		corsConfiguration.setExposedHeaders(Arrays.asList(
				"Origin",
				"Access-Control-Allow-Origin",
				"Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Request-With",
				"Access-Control-Allow-Method", "Access-Control-Allow-Credentials", "Filename"
		));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","DELETE","PUT", "PATCH", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}



}
