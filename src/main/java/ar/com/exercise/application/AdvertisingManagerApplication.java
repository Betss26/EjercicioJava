package ar.com.exercise.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"ar.com.exercise"})
@SpringBootConfiguration
@EnableJpaRepositories("ar.com.exercise.application.repository")
public class AdvertisingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvertisingManagerApplication.class, args);
	}

}
