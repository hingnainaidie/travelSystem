package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (ComplaintEvent)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:42:32
 */
public class ComplaintEvent implements Serializable {
    private static final long serialVersionUID = -48467807203316087L;
    
    private Long complaintId;
    
    private Long tuserId;
    
    private Long suserId;
    
    private String complaintDescription;
    
    private String complaintBegintime;
    
    private String complaintStatus;
    
    private Date complaintEndtime;
    
    private String complaintResult;


    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getTuserId() {
        return tuserId;
    }

    public void setTuserId(Long tuserId) {
        this.tuserId = tuserId;
    }

    public Long getSuserId() {
        return suserId;
    }

    public void setSuserId(Long suserId) {
        this.suserId = suserId;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getComplaintBegintime() {
        return complaintBegintime;
    }

    public void setComplaintBegintime(String complaintBegintime) {
        this.complaintBegintime = complaintBegintime;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public Date getComplaintEndtime() {
        return complaintEndtime;
    }

    public void setComplaintEndtime(Date complaintEndtime) {
        this.complaintEndtime = complaintEndtime;
    }

    public String getComplaintResult() {
        return complaintResult;
    }

    public void setComplaintResult(String complaintResult) {
        this.complaintResult = complaintResult;
    }

}

