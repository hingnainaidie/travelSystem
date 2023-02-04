package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TripEvent)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:53:28
 */
public class TripEvent implements Serializable {
    private static final long serialVersionUID = -52513541645239934L;
    
    private Long tripEventId;
    
    private Long emergencyId;
    
    private Long userId;
    
    private String tripEventTitle;
    
    private String tripEventDescription;
    
    private String tripEventClassification;
    
    private String tripEventLocation;
    
    private Integer tripEventStatus;
    
    private Date tripEventTime;
    
    private String tripEventInfo;
    
    private String staffWarningInformation;
    
    private String guidanceInstructionInfo;


    public Long getTripEventId() {
        return tripEventId;
    }

    public void setTripEventId(Long tripEventId) {
        this.tripEventId = tripEventId;
    }

    public Long getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(Long emergencyId) {
        this.emergencyId = emergencyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTripEventTitle() {
        return tripEventTitle;
    }

    public void setTripEventTitle(String tripEventTitle) {
        this.tripEventTitle = tripEventTitle;
    }

    public String getTripEventDescription() {
        return tripEventDescription;
    }

    public void setTripEventDescription(String tripEventDescription) {
        this.tripEventDescription = tripEventDescription;
    }

    public String getTripEventClassification() {
        return tripEventClassification;
    }

    public void setTripEventClassification(String tripEventClassification) {
        this.tripEventClassification = tripEventClassification;
    }

    public String getTripEventLocation() {
        return tripEventLocation;
    }

    public void setTripEventLocation(String tripEventLocation) {
        this.tripEventLocation = tripEventLocation;
    }

    public Integer getTripEventStatus() {
        return tripEventStatus;
    }

    public void setTripEventStatus(Integer tripEventStatus) {
        this.tripEventStatus = tripEventStatus;
    }

    public Date getTripEventTime() {
        return tripEventTime;
    }

    public void setTripEventTime(Date tripEventTime) {
        this.tripEventTime = tripEventTime;
    }

    public String getTripEventInfo() {
        return tripEventInfo;
    }

    public void setTripEventInfo(String tripEventInfo) {
        this.tripEventInfo = tripEventInfo;
    }

    public String getStaffWarningInformation() {
        return staffWarningInformation;
    }

    public void setStaffWarningInformation(String staffWarningInformation) {
        this.staffWarningInformation = staffWarningInformation;
    }

    public String getGuidanceInstructionInfo() {
        return guidanceInstructionInfo;
    }

    public void setGuidanceInstructionInfo(String guidanceInstructionInfo) {
        this.guidanceInstructionInfo = guidanceInstructionInfo;
    }

}

