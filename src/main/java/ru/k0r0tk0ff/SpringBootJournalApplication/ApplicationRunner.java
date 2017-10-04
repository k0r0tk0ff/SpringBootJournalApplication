package ru.k0r0tk0ff.SpringBootJournalApplication;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Journal;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.ClientRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.JournalRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.PetRepository;


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

	@Bean
	InitializingBean saveData(ClientRepository clientRepo) {
		return () -> {
			clientRepo.save(
					new Client("asdf", "pa$$", "Name", "FamilyName", "+79991234599"));
		};
	}
	@Bean
	InitializingBean saveData(PetRepository petRepo) {
		return () -> {
			petRepo.save(
					new Pet("Markiz", "cat", "2.0 kg"));
		};
	}



	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}
}
