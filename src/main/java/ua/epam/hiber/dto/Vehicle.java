package ua.epam.hiber.dto;

import javax.persistence.*;

/**
 * Created by Dmytro_Adonin on 11/4/2015.
 */
@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String type;

    /*@ManyToOne
    @NotFound(action = NotFoundAction.IGNORE) //Hibernate-specific
    private User user;*/

    /*@ManyToMany(mappedBy = "vehicles")
    private Collection<User> users = new ArrayList<User>();*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    /*public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }*/
}
