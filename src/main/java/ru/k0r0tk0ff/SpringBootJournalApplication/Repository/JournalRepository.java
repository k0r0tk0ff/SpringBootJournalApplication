package ru.k0r0tk0ff.SpringBootJournalApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.k0r0tk0ff.SpringBootJournalApplication.Models.Journal;

/**
 * Created by k0r0tk0ff on 9/27/2017.
 *
 * JpaRepository — это интерфейс фреймворка Spring Data предоставляющий набор стандартных методов JPA для работы с БД.
 * например List<Object> getAll() - возвратит список 
 *
 * можно написать свой кастомный метод -
 * public interface BankRepository extends JpaRepository<Journal, Long> {
 *
 *   @Query("select b from Journal b where b.title = :titleName")
 *   Journal findByTitle(@Param("titleName") String titleName);
 * 
 *}
 * 
 */
public interface JournalRepository extends JpaRepository <Journal, Long> {
}
