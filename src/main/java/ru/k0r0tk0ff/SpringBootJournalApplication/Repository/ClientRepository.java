package ru.k0r0tk0ff.SpringBootJournalApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Client;

/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

public interface ClientRepository extends JpaRepository<Client, Long> {
}
