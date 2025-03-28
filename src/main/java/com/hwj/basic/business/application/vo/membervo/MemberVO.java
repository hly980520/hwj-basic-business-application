package com.hwj.basic.business.application.vo.membervo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户管理
public class MemberVO implements Serializable {
    private static final long serialVersionUID = 142076892042893752L;

    private Long id;

    private String nickname;

    private String loginAccount;

    private String phoneNumber;

    //注册时间
    private LocalDateTime registerTime;

    private String registerWay;

    //三方号
    private String thirdNum;

    //用户状态
    private String memberStatus;

    private LocalDateTime updatedDate;

    private String updatedBy;


    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public String getThirdNum() {
        return thirdNum;
    }

    public void setThirdNum(String thirdNum) {
        this.thirdNum = thirdNum;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MemberVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nickname='" + nickname + "'")
                .add("loginAccount='" + loginAccount + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("registerWay='" + registerWay + "'")
                .add("thirdNum='" + thirdNum + "'")
                .add("memberStatus=" + memberStatus)
                .add("updatedDate=" + updatedDate)
                .add("updatedBy='" + updatedBy + "'")
                .toString();
    }

}
