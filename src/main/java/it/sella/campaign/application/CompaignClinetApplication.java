package it.sella.campaign.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.sella.campaign.configuration.ElasticSearchConfiguration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "it.sella.campaign")
public class CompaignClinetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompaignClinetApplication.class, args);
	}
}
