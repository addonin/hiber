package ua.epam.hiber.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY"))
    })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;*/

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    /*hibernate-specific
    @GenericGenerator(name = "ADDRESS_ID_GEN", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"),
                  generator = "ADDRESS_ID_GEN",
                  type = @Type(type = "long"))*/
    //private Set<Address> addresses = new HashSet<Address>();
    private Collection<Address> addresses = new ArrayList<Address>();

    /*@OneToOne
    @JoinColumn(name = "VEHICLE_ID")*/
    //@OneToMany(mappedBy = "user")
    /*@JoinTable(name = "USER_VEHICLES",
               joinColumns = @JoinColumn(name = "USER_ID"),
               inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))*/
    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

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

    public Collection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Collection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /*public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/

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
