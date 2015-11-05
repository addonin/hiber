package ua.epam.hiber.dto;

import javax.persistence.*;

/**
 * Created by Dmytro_Adonin on 11/5/2015.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "userName.byId", query = "select userName from UserDetails where id = :id")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "userDetails.byUserName", query = "SELECT ID FROM userdetails WHERE userName = ?",
                resultClass = UserDetails.class)
})
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
