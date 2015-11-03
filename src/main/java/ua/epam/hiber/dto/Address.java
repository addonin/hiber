package ua.epam.hiber.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Dmytro_Adonin on 11/3/2015.
 */
@Embeddable
public class Address {

    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
