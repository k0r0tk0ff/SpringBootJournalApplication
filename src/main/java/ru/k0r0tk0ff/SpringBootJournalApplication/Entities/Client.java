package ru.k0r0tk0ff.SpringBootJournalApplication.Entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by k0r0tk0ff on 10/3/2017.
 */

@Table
@Entity
public class Client {

    public Client() {
    }

    public Client(String login, String pasword, String firstName, String lastName, String tel) {
        this.login = login;
        this.pasword = pasword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    private String login;
    private String pasword;
    private String firstName;
    private String lastName;
    private String tel;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "Value",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "clientId") })
    private Set<Pet> pets = new HashSet<>();


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPasword() { return pasword; }

    public void setPasword(String pasword) { this.pasword = pasword; }

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

        if (id != client.id) return false;
        if (!login.equals(client.login)) return false;
        if (!pasword.equals(client.pasword)) return false;
        if (!firstName.equals(client.firstName)) return false;
        if (!lastName.equals(client.lastName)) return false;
        return tel.equals(client.tel);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + login.hashCode();
        result = 31 * result + pasword.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + tel.hashCode();
        return result;
    }
}
