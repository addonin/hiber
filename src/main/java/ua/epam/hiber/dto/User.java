package ua.epam.hiber.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dmytro_Adonin on 11/3/2015.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    private int id;
    @Basic(optional = false)
    private String name;
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Transient
    private String transcient;
    @Lob
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getTranscient() {
        return transcient;
    }

    public void setTranscient(String transcient) {
        this.transcient = transcient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
