package ru.k0r0tk0ff.SpringBootJournalApplication;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.k0r0tk0ff.SpringBootJournalApplication.Models.Journal;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.JournalRepository;

@SpringBootApplication(scanBasePackages = "ru.k0r0tk0ff.SpringBootJournalApplication")
public class ApplicationRunner {

	@Bean
	InitializingBean saveData(JournalRepository repo) {
		return () -> {
			repo.save(
					new Journal("Get know springboot", "test summury", "27/09/2017"));
			repo.save(
					new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
			repo.save(
					new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}
}
