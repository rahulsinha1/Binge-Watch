package edu.northeastern.cs5200;

import edu.northeastern.cs5200.controllers.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Cs5200Spring2020Team2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring2020Team2Application.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
		
		 return args -> {
	            userRepository.findAll().forEach(System.out::println);
	        };
		
	}

}
