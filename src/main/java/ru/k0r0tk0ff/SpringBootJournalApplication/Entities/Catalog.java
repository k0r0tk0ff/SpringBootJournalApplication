package ru.k0r0tk0ff.SpringBootJournalApplication.Entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by k0r0tk0ff on 10/7/2017.
 */

@Entity
@Table(name = "CATALOG")
@IdClass(Catalog.class)
public class Catalog implements Serializable{

    @Id
    @OneToOne
    private Client client;

    @Id
    @OneToOne
    private Pet pet;
}
