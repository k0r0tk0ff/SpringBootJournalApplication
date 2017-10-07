package ru.k0r0tk0ff.SpringBootJournalApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Catalog;
import ru.k0r0tk0ff.SpringBootJournalApplication.Repository.CatalogRepository;

import java.util.List;


/**
 * Created by user on 10/7/2017.
 */

@RestController
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepo;

    @RequestMapping("/showcatalog")
    public @ResponseBody
    List<Catalog> getAll() {
        return catalogRepo.findAll();
    }
}
