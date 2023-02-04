package com.cqu.travelsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (CaseEvent)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:42:17
 */
public class CaseEvent implements Serializable {
    private static final long serialVersionUID = -10450408075365249L;
    
    private Long caseId;
    
    private Long tuserId;
    
    private Long suserId;
    
    private String caseDescription;
    
    private Date caseBegintime;
    
    private Date caseMidtime;
    
    private Date caseEndtime;
    
    private Integer caseStatus;
    
    private String caseResults;
    
    private String casePlace;


    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
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

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public Date getCaseBegintime() {
        return caseBegintime;
    }

    public void setCaseBegintime(Date caseBegintime) {
        this.caseBegintime = caseBegintime;
    }

    public Date getCaseMidtime() {
        return caseMidtime;
    }

    public void setCaseMidtime(Date caseMidtime) {
        this.caseMidtime = caseMidtime;
    }

    public Date getCaseEndtime() {
        return caseEndtime;
    }

    public void setCaseEndtime(Date caseEndtime) {
        this.caseEndtime = caseEndtime;
    }

    public Integer getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(Integer caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseResults() {
        return caseResults;
    }

    public void setCaseResults(String caseResults) {
        this.caseResults = caseResults;
    }

    public String getCasePlace() {
        return casePlace;
    }

    public void setCasePlace(String casePlace) {
        this.casePlace = casePlace;
    }

}

