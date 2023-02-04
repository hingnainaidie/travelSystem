package com.cqu.travelsystem.entity;

import java.io.Serializable;

/**
 * (Parking)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:43:45
 */
public class Parking implements Serializable {
    private static final long serialVersionUID = 879747864143561472L;
    
    private Long parkingId;
    
    private String parkingLocation;
    
    private Long parkingMaxCapacity;
    
    private Long parkingRemainingCapacity;


    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(String parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

    public Long getParkingMaxCapacity() {
        return parkingMaxCapacity;
    }

    public void setParkingMaxCapacity(Long parkingMaxCapacity) {
        this.parkingMaxCapacity = parkingMaxCapacity;
    }

    public Long getParkingRemainingCapacity() {
        return parkingRemainingCapacity;
    }

    public void setParkingRemainingCapacity(Long parkingRemainingCapacity) {
        this.parkingRemainingCapacity = parkingRemainingCapacity;
    }

}

