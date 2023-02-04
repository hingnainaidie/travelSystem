package com.cqu.travelsystem.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Scenic)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:52:48
 */
@ToString
public class Scenic implements Serializable {
    private static final long serialVersionUID = -40273820032763381L;
    
    private Long scenicId;
    
    private String scenicName;
    
    private String scenicLocation;
    
    private String scenicProfile;
    
    private Long scenicCapacity;
    
    private Long scenicCurrentNumber;
    
    private Integer scenicPrice;


    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getScenicLocation() {
        return scenicLocation;
    }

    public void setScenicLocation(String scenicLocation) {
        this.scenicLocation = scenicLocation;
    }

    public String getScenicProfile() {
        return scenicProfile;
    }

    public void setScenicProfile(String scenicProfile) {
        this.scenicProfile = scenicProfile;
    }

    public Long getScenicCapacity() {
        return scenicCapacity;
    }

    public void setScenicCapacity(Long scenicCapacity) {
        this.scenicCapacity = scenicCapacity;
    }

    public Long getScenicCurrentNumber() {
        return scenicCurrentNumber;
    }

    public void setScenicCurrentNumber(Long scenicCurrentNumber) {
        this.scenicCurrentNumber = scenicCurrentNumber;
    }

    public Integer getScenicPrice() {
        return scenicPrice;
    }

    public void setScenicPrice(Integer scenicPrice) {
        this.scenicPrice = scenicPrice;
    }

}

