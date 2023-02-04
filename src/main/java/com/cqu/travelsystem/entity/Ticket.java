package com.cqu.travelsystem.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Ticket)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:59:54
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket implements Serializable {
    private static final long serialVersionUID = 596574772428157558L;
    
    private Long ticketId;
    
    private Long userId;
    
    private Long scenicId;
    
    private Date ticketBuyTime;
    
    private Integer ticketUsetimeYear;
    
    private Integer ticketUsetimeMonth;
    
    private Integer ticketUsetimeDay;
    
    private Long ticketPrice;
    
    private Integer ticketStatus;


    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public Date getTicketBuyTime() {
        return ticketBuyTime;
    }

    public void setTicketBuyTime(Date ticketBuyTime) {
        this.ticketBuyTime = ticketBuyTime;
    }

    public Integer getTicketUsetimeYear() {
        return ticketUsetimeYear;
    }

    public void setTicketUsetimeYear(Integer ticketUsetimeYear) {
        this.ticketUsetimeYear = ticketUsetimeYear;
    }

    public Integer getTicketUsetimeMonth() {
        return ticketUsetimeMonth;
    }

    public void setTicketUsetimeMonth(Integer ticketUsetimeMonth) {
        this.ticketUsetimeMonth = ticketUsetimeMonth;
    }

    public Integer getTicketUsetimeDay() {
        return ticketUsetimeDay;
    }

    public void setTicketUsetimeDay(Integer ticketUsetimeDay) {
        this.ticketUsetimeDay = ticketUsetimeDay;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

}

