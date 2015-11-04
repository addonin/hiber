package ua.epam.hiber.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Dmytro_Adonin on 11/4/2015.
 */
@Entity
@DiscriminatorValue(value = "Bike")
public class TwoWheeler extends Vehicle {

    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
