package ru.k0r0tk0ff.SpringBootJournalApplication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.ClientRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.PetRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 10/7/2017.
 */
@Service
public class ClientAndPetServiceImpl implements ClientAndPetService {

    private final ClientRepository clientRepo;
    private final PetRepository petRepo;

    @Autowired
    public ClientAndPetServiceImpl (final ClientRepository clientRepo, final PetRepository petRepo) {
        this.clientRepo = clientRepo;
        this.petRepo = petRepo;
    }


    @Override
    public List<Client> getAll() {
        return ((List<Client>) this.clientRepo.findAll());
    }

    @Override
    public Set <Pet> getPetsByClient(long clientId) {
        return (Set) this.clientRepo.getOne(clientId).getPets();
    }

    @Override
    public List<Pet> findAllPets() {
        return ((List<Pet>) this.petRepo.findAll());
    }
}
