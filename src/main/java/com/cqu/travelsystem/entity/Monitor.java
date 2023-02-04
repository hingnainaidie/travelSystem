package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Monitor)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:43:35
 */
public class Monitor implements Serializable {
    private static final long serialVersionUID = 667162583517583063L;
    
    private Long monitorId;
    
    private Long scenicId;
    
    private String monitorLocation;
    
    private Date monitorTime;
    
    private String monitorContent;


    public Long getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public String getMonitorLocation() {
        return monitorLocation;
    }

    public void setMonitorLocation(String monitorLocation) {
        this.monitorLocation = monitorLocation;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public String getMonitorContent() {
        return monitorContent;
    }

    public void setMonitorContent(String monitorContent) {
        this.monitorContent = monitorContent;
    }

}

