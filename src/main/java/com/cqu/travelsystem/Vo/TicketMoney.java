package com.cqu.travelsystem.Vo;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketMoney {

    private Long scenicId;

    private Integer ticketUsetimeYear;

    private Integer ticketUsetimeMonth;

    private Integer ticketUsetimeDay;

    private Long money;

}
