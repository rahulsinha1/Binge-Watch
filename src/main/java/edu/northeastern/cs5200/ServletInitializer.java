package edu.northeastern.cs5200;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder
		configure(SpringApplicationBuilder application) {
		return application.sources(
				Cs5200Spring2020Team2Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(
				Cs5200Spring2020Team2Application.class, args);
	}


}
