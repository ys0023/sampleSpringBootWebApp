package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * アプリケーション起動クラス.
 */
@SpringBootApplication
public class Demo2Application extends ServletInitializer {

	public static void main(String[] args) {
		
		SpringApplication.run(Demo2Application.class, args);

		ServletInitializer init  = new ServletInitializer();
		init.configure(new SpringApplicationBuilder());
	}

}
