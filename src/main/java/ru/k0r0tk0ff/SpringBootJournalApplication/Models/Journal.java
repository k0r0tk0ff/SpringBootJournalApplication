package ru.k0r0tk0ff.SpringBootJournalApplication.Models;

import javax.persistence.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


/**
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

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Journal(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.summary = summary;
        this.created = format.parse(date);
    }

    public Journal(){}

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'title'.
     *
     * @return Value for property 'title'.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for property 'title'.
     *
     * @param title Value to set for property 'title'.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for property 'created'.
     *
     * @return Value for property 'created'.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Setter for property 'created'.
     *
     * @param created Value to set for property 'created'.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Getter for property 'summary'.
     *
     * @return Value for property 'summary'.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Setter for property 'summary'.
     *
     * @param summary Value to set for property 'summary'.
     */
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
