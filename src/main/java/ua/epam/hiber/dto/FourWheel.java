package ua.epam.hiber.dto;

import javax.persistence.Entity;

/**
 * Created by Dmytro_Adonin on 11/4/2015.
 */
@Entity
public class FourWheel extends Vehicle {

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
