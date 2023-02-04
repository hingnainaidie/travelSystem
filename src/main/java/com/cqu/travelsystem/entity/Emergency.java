package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Emergency)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:43:02
 */
public class Emergency implements Serializable {
    private static final long serialVersionUID = 106852815949188878L;
    
    private Long emergencyId;
    
    private Long userId;
    
    private String emergencyName;
    
    private String emergencyClassification;
    
    private String emergencyDescription;
    
    private Date emergencyTime;
    
    private String emergencySolution;


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

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyClassification() {
        return emergencyClassification;
    }

    public void setEmergencyClassification(String emergencyClassification) {
        this.emergencyClassification = emergencyClassification;
    }

    public String getEmergencyDescription() {
        return emergencyDescription;
    }

    public void setEmergencyDescription(String emergencyDescription) {
        this.emergencyDescription = emergencyDescription;
    }

    public Date getEmergencyTime() {
        return emergencyTime;
    }

    public void setEmergencyTime(Date emergencyTime) {
        this.emergencyTime = emergencyTime;
    }

    public String getEmergencySolution() {
        return emergencySolution;
    }

    public void setEmergencySolution(String emergencySolution) {
        this.emergencySolution = emergencySolution;
    }

}

