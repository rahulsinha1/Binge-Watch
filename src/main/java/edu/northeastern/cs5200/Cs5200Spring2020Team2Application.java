package edu.northeastern.cs5200;

import edu.northeastern.cs5200.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Cs5200Spring2020Team2Application {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Cs5200Spring2020Team2Application.class);
    app.setDefaultProperties(Collections
            .singletonMap("server.port", "8083"));
    app.run(args);
  }


  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository) {


    return args -> {
      userRepository.findAll().forEach(System.out::println);
    };

  }

}
