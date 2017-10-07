package ru.k0r0tk0ff.SpringBootJournalApplication.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;


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


    private String nick;
    private String kind;
    private String weight;

    //@ManyToMany(fetch = FetchType.LAZY)
    //@ManyToMany(mappedBy = pets)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "CATALOG",
            joinColumns = { @JoinColumn(name = "PET_ID") },
            inverseJoinColumns = { @JoinColumn(name = "CLIENT_ID") }
    )
    private Set<Client> clients;

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Id
/*    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "PET_ID")
    private long petId;

    public long getPetId() { return petId; }

    public void setPetId(long petId) { this.petId = petId; }

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

        if (petId != pet.petId) return false;
        if (!nick.equals(pet.nick)) return false;
        if (!kind.equals(pet.kind)) return false;
        return weight.equals(pet.weight);
    }

    @Override
    public int hashCode() {
        int result = (int) (petId ^ (petId >>> 32));
        result = 31 * result + nick.hashCode();
        result = 31 * result + kind.hashCode();
        result = 31 * result + weight.hashCode();
        return result;
    }
}
