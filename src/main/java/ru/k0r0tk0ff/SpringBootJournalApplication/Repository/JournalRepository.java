package ru.k0r0tk0ff.SpringBootJournalApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Models.Journal;

/**
 * Created by user on 9/27/2017.
 */
public interface JournalRepository extends JpaRepository <Journal, Long> {
}
