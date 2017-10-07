package ru.k0r0tk0ff.SpringBootJournalApplication.Services;

import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by k0r0tk0ff on 10/7/2017.
 */


public interface ClientAndPetService {

    List<Client> getAll();

    Set<Pet> getPetsByClient(long clientId);

    List<Pet> findAllPets();

}
