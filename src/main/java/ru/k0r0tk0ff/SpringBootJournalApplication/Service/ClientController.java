package ru.k0r0tk0ff.SpringBootJournalApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.ClientRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.PetRepository;

import java.util.*;


/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private PetRepository petRepo;

    @RequestMapping("/showallclients")
    public @ResponseBody
    List<Client> getClientsAsList() {
        return clientRepo.findAll();
    }

    @RequestMapping("/showallpets")
    public @ResponseBody
    List<Pet> getPetsAsList() {
        return petRepo.findAll();
    }


    @RequestMapping("/client")
    public @ResponseBody
    List<String> getClientsAsListWithHisPets(@RequestParam(value="id", defaultValue="1") String id) {
        List<String> out = new ArrayList<>();
        Set<Pet> outPet = new HashSet<>();


        //Client client = clientRepo.getOne(@PathVariable("id") Long id);
        Client client = clientRepo.findOne(Long.valueOf(id));
        out.add(client.getFirstName());
        out.add(client.getLastName());
        out.add(client.getLogin());
        out.add(client.getTel());

        outPet = client.getPets();
        for(Pet pet : outPet) {
            out.add(pet.getNick());
            out.add(pet.getNick());
            out.add(pet.getNick());
            out.add(pet.getNick());
        }

        return out;
    }

}
