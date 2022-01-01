package com.talento.worldparts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WorldPartsApplication extends SpringBootServletInitializer{
	
	// Used when run as JAR
	public static void main(String[] args) {
		SpringApplication.run(WorldPartsApplication.class, args);
	}
	
	// Used when run as WAR
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WorldPartsApplication.class);
	}

}
