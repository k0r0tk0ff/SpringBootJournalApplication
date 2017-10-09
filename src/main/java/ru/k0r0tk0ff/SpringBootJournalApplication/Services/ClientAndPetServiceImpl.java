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
    public Set <Pet> getPetsByClientId(long clientId) {
        return (Set) this.clientRepo.findOne(clientId).getPets();
    }

    @Override
    public List<Pet> findAllPets() {
        return ((List<Pet>) this.petRepo.findAll());
    }

    @Override
    public void saveClient(Client client) {
        this.clientRepo.save(client);
    }
    @Override
    public void savePet(Pet pet) {
        this.petRepo.save(pet);
    }
}
