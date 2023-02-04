package com.cqu.travelsystem.entity;

import lombok.*;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-06-25 09:53:54
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 275900507538376273L;
    
    private Long userId;
    
    private Long scenicId;
    
    private String userName;
    
    private String userGender;
    
    private String userIdentify;
    
    private Integer userLevel;
    
    private String userPhone;
    
    private String userAccount;
    
    private String userPassword;


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserIdentify() {
        return userIdentify;
    }

    public void setUserIdentify(String userIdentify) {
        this.userIdentify = userIdentify;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}

