package ru.k0r0tk0ff.SpringBootJournalApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.ClientRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.PetRepository;

import java.util.List;


/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private PetRepository petRepo;

    @RequestMapping("/asdf")
    public @ResponseBody
    List<Client> getValue() {
        return clientRepo.findAll();
    }

}
