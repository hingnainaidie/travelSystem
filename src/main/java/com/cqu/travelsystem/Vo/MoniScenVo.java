package com.cqu.travelsystem.Vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class MoniScenVo {
    private Long monitorId;

    private String scenicName;

    private String monitorLocation;

    private Date monitorTime;

    private String monitorContent;
}
