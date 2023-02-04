package com.cqu.travelsystem.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * trip_event_time 旅游事件时间
 * trip_event_title 旅游事件名称
 * trip_event_location 旅游事件发生地点
 * trip_event_classification 旅游事件类别
 * user_name 旅游事件值班人员名字
 * trip_event_description  旅游事件描述
 * staff_warning_information 预警信息内容
 * guidance_instruction_info 诱导与指令信息
 */

@Data   //添加getter/setter
@NoArgsConstructor     //添加无参构造器
@AllArgsConstructor     //添加全参构造器
@Accessors(chain = true)    //添加链式调用
public class TripEventVo {
    private Date tripEventTime;

    private String userName;

    private String tripEventTitle;

    private String tripEventDescription;

    private String tripEventClassification;

    private String tripEventLocation;

    private String staffWarningInformation;

    private String guidanceInstructionInfo;
}
