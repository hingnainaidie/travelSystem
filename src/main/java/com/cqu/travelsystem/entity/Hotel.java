package com.cqu.travelsystem.entity;

import java.io.Serializable;

/**
 * (Hotel)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:43:20
 */
public class Hotel implements Serializable {
    private static final long serialVersionUID = 290592726532967024L;
    
    private Long hotelId;
    
    private Long hotelMaxCapacity;
    
    private Long hotelRemainingCapacity;
    
    private String hotelName;
    
    private String hotelLocation;


    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getHotelMaxCapacity() {
        return hotelMaxCapacity;
    }

    public void setHotelMaxCapacity(Long hotelMaxCapacity) {
        this.hotelMaxCapacity = hotelMaxCapacity;
    }

    public Long getHotelRemainingCapacity() {
        return hotelRemainingCapacity;
    }

    public void setHotelRemainingCapacity(Long hotelRemainingCapacity) {
        this.hotelRemainingCapacity = hotelRemainingCapacity;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

}

