package com.cqu.travelsystem.Vo;

import lombok.*;

import java.util.Date;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//查看游客信息视图
public class visiterVo {
    private String userName;

    private String userGender;

    private String userPhone;

    private String userAccount;

    private Long ticketId;

    private Integer ticketStatus;

    private String scenicName;

    private Long scenicId;

    private Date ticketBuyTime;

    private Integer ticketUsetimeYear;

    private Integer ticketUsetimeMonth;

    private Integer ticketUsetimeDay;

    private String ticketUsetime;

    //拼接获得日期
    public void setUsetime(){
        ticketUsetime = (ticketUsetimeYear) + "-" + (ticketUsetimeMonth) + "-" + (ticketUsetimeDay);
    }
}
