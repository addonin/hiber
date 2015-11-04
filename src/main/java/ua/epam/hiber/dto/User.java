package ua.epam.hiber.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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

    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
    })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;*/

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name = "ADDRESS_ID_GEN", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"),
                  generator = "ADDRESS_ID_GEN",
                  type = @Type(type = "long"))
    //private Set<Address> addresses = new HashSet<Address>();
    private Collection<Address> addresses = new ArrayList<Address>();

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

    /*public Address getHomeAddress() {
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
    }*/

    /*public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }*/

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
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
