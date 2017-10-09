package ru.k0r0tk0ff.SpringBootJournalApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;
import ru.k0r0tk0ff.SpringBootJournalApplication.Services.ClientAndPetService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by user on 10/7/2017.
 */

@RestController
public class ClientAndPetServiceController {

    private final ClientAndPetService clientAndPetService;

    @Autowired
    public ClientAndPetServiceController(final ClientAndPetService clientAndPetService) {
        this.clientAndPetService = clientAndPetService;
    }

    @RequestMapping("/showclients")
    public @ResponseBody
    List<Client> getAll() {
        return clientAndPetService.getAll();
    }

    @RequestMapping("/client")
    public @ResponseBody
    Set<Pet> getClientsAsListWithHisPets(@RequestParam(value="id") String id) {
        Set<Pet> outPet;
        outPet = clientAndPetService.getPetsByClientId(Long.valueOf(id));
        return outPet;
    }

    /*    @RequestMapping("/showallclients")
    public @ResponseBody
    List<Client> getClientsAsList() {
        return clientAndPetService.findAll();
    }*/

    @RequestMapping("/showallpets")
    public @ResponseBody
    List<Pet> getPetsAsList() {
        return clientAndPetService.findAllPets();
    }
}
