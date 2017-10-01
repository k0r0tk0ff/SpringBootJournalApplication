package ru.k0r0tk0ff.SpringBootJournalApplication.Models;

import javax.persistence.Entity;
import javax.persistence.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


/**.
 * Created by k0r0tk0ff on 9/27/2017.
 */

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private Date created;
    private String summary;

    /*
    * @Transient означает, что переменая SimpleDateFormat format не будет записываться в базу данных
    */
    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    /*
    * Для корректной работы Spring Data JPA необходимы 
    * a) коструктор со всеми параметрами 
    */   
    public Journal(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(date);
    }

    /*
    * б) коструктор без параметров 
    */
    public Journal(){}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getCreatedAsShort() {
        return format.format(created);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", created=" + created +
                ", summary='" + summary + '\'' +
                ", format=" + format +
                '}';
    }
}
