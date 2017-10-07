package ru.k0r0tk0ff.SpringBootJournalApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Catalog;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;

/**
 * Created by user on 10/7/2017.
 */

public interface CatalogRepository extends JpaRepository<Catalog, Client> {
}
