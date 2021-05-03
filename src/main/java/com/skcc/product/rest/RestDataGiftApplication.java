package com.skcc.product.rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestDataGiftApplication {

	private static final String PROPERTIES =
									"spring.config.location="
									+ "classpath:/config/application/";
		
	public static void main(String[] args) {
		new SpringApplicationBuilder(RestDataGiftApplication.class)
            .properties(PROPERTIES)
            .run(args);
	}

}
