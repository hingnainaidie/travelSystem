package com.cqu.travelsystem.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data   //添加getter/setter
@NoArgsConstructor     //添加无参构造器
@AllArgsConstructor     //添加全参构造器
@Accessors(chain = true)    //添加链式调用
public class TicketScenic {
    private Long ticketId;
    private String scenicName;
    private String scenicLocation;
    private Date ticketBuyTime;
    private String ticketUsetime;
    private Integer ticketUsetimeYear;
    private Integer ticketUsetimeMonth;
    private Integer ticketUsetimeDay;
    private Long ticketPrice;
    private Integer ticketStatus;
}
