package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TripInfo)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:53:44
 */
public class TripInfo implements Serializable {
    private static final long serialVersionUID = 320033361197307007L;
    
    private Long tripInfoId;
    
    private Long suserId;
    
    private String tripInfoTitle;
    
    private String tripInfoDescription;
    
    private Date tripInfoTime;
    
    private Integer tripInfoStatus;


    public Long getTripInfoId() {
        return tripInfoId;
    }

    public void setTripInfoId(Long tripInfoId) {
        this.tripInfoId = tripInfoId;
    }

    public Long getSuserId() {
        return suserId;
    }

    public void setSuserId(Long suserId) {
        this.suserId = suserId;
    }

    public String getTripInfoTitle() {
        return tripInfoTitle;
    }

    public void setTripInfoTitle(String tripInfoTitle) {
        this.tripInfoTitle = tripInfoTitle;
    }

    public String getTripInfoDescription() {
        return tripInfoDescription;
    }

    public void setTripInfoDescription(String tripInfoDescription) {
        this.tripInfoDescription = tripInfoDescription;
    }

    public Date getTripInfoTime() {
        return tripInfoTime;
    }

    public void setTripInfoTime(Date tripInfoTime) {
        this.tripInfoTime = tripInfoTime;
    }

    public Integer getTripInfoStatus() {
        return tripInfoStatus;
    }

    public void setTripInfoStatus(Integer tripInfoStatus) {
        this.tripInfoStatus = tripInfoStatus;
    }

}

