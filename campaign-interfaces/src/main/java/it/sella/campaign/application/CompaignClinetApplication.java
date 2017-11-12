package it.sella.campaign.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "it.sella.campaign")
public class CompaignClinetApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CompaignClinetApplication.class, args);
	}
}
