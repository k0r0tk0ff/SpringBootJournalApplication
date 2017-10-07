package ru.k0r0tk0ff.SpringBootJournalApplication.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    public Client() {
    }

    public Client(String login, String pasword, String firstName, String lastName, String tel) {
        this.login = login;
        this.password = pasword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
    }

    @Id
/*    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="CLIENT_ID")
    private long clientId;

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String tel;


/* work variant*/
/*    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();*/

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(
            name = "CATALOG",
            joinColumns = { @JoinColumn(name = "CLIENT_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PET_ID") }
    )
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void setPet(Pet pet) {
        this.pets.add(pet);
    }

    public long getId() { return clientId; }

    public void setId(long id) { this.clientId = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPasword() { return password; }

    public void setPasword(String pasword) { this.password = pasword; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (!login.equals(client.login)) return false;
        if (!password.equals(client.password)) return false;
        if (!firstName.equals(client.firstName)) return false;
        if (!lastName.equals(client.lastName)) return false;
        return tel.equals(client.tel);
    }

    @Override
    public int hashCode() {
        int result = (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + tel.hashCode();
        return result;
    }
}
