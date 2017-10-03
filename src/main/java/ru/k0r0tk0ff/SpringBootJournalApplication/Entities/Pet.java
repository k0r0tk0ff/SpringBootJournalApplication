package ru.k0r0tk0ff.SpringBootJournalApplication.Entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@Table
@Entity
public class Pet {

    public Pet() {
    }

    public Pet(String nick, String kind, String weight) {
        this.nick = nick;
        this.kind = kind;
        this.weight = weight;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    private String nick;
    private String kind;
    private String weight;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "Value",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "petId") })
    private Collection<Client> clients = new ArrayList<>();



    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNick() { return nick; }


    public void setNick(String nick) { this.nick = nick; }

    public String getKind() { return kind; }

    public void setKind(String kind) { this.kind = kind; }

    public String getWeight() { return weight; }

    public void setWeight(String weight) { this.weight = weight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (id != pet.id) return false;
        if (!nick.equals(pet.nick)) return false;
        if (!kind.equals(pet.kind)) return false;
        return weight.equals(pet.weight);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + nick.hashCode();
        result = 31 * result + kind.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }
}
