package com.cqu.travelsystem.Vo;

import lombok.*;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Long userId;

    private Long scenicId;

    private String scenicName;

    private String userName;

    private String userGender;

    private String userIdentify;

    private Integer userLevel;

    private String userPhone;

    private String userAccount;

    private String userPassword;
}
