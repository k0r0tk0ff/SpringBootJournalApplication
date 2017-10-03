package ru.k0r0tk0ff.SpringBootJournalApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Entities.Pet;

/**
 * Created by user on 10/3/2017.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
