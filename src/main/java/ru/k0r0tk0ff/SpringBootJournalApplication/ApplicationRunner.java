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
import ru.k0r0tk0ff.SpringBootJournalApplication.Services.ClientAndPetService;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication(scanBasePackages = "ru.k0r0tk0ff.SpringBootJournalApplication")
public class ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRunner.class, args);
	}

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

/*	@Bean
	InitializingBean savePets(PetRepository petRepo) {
		return () -> {
			petRepo.save(
					new Pet("Markiz", "cat", "2.0 kg"));
		};
	}*/


/*	@Bean
	InitializingBean saveClients(ClientRepository clientRepo, PetRepository petRepo) {
		return () -> {
*//*			clientRepo.save(
					new Client("asdf", "pa$$", "Name", "FamilyName", "+79991234599"));
			clientRepo.save(
					new Client("aaaa", "pa$$", "aaaa", "FamilyName2", "+78881234599"));*//*

			Client clientThree = new Client("bbbb", "pa$$", "bbbb", "FamilyName3", "+77771234599");
			clientRepo.save(clientThree);

			Pet cat = new Pet("Markiz", "cat", "2.0 kg");
			petRepo.save(cat);

			Set<Pet> pets = new HashSet<>(0);
			Set<Client> clients = new HashSet<>(0);
			pets.add(cat);
			clients.add(clientThree);
			cat.setClients(clients);
			clientThree.setPets(pets);

		};
	}*/

	@Bean
	InitializingBean saveClients(ClientAndPetService service) {
		return () -> {

			Client clientThree = new Client("bbbb", "pa$$", "bbbb", "FamilyName3", "+77771234599");
//			clientRepo.save(clientThree);


			Pet cat = new Pet("Markiz", "cat", "2.0 kg");
//			petRepo.save(cat);

			Set<Pet> pets = new HashSet<>(0);
			Set<Client> clients = new HashSet<>(0);
			pets.add(cat);
			clients.add(clientThree);
			cat.setClients(clients);
			clientThree.setPets(pets);
			service.saveClient(clientThree);
			//service.savePet(cat);
		};
	}



}
