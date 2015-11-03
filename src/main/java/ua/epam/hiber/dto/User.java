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
    //@EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
    })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address address) {
        this.homeAddress = address;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
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
