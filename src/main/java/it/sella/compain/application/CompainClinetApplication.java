package it.sella.compain.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.sella.compain.configuration.ElasticSearchConfiguration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "it.sella.compain")
public class CompainClinetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompainClinetApplication.class, args);
	}
}
