package com.hwj.basic.business.application.vo.membervo;

import com.hwj.basic.common.member.domain.Member;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
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

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay;
    }

    public static MemberVO of(Member member) {
        if (Objects.isNull(member)) {
            return null;
        }

        MemberVO vo = new MemberVO();
        vo.setId(member.getId());
        vo.setNickname(member.getNickname());
        vo.setLoginAccount(member.getLoginAccount());
        vo.setPhoneNumber(member.getPhoneNumber());
        vo.setRegisterWay(member.getRegisterWay());
        vo.setRegisterTime(member.getCreatedDate());
        return vo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MemberVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nickname='" + nickname + "'")
                .add("loginAccount='" + loginAccount + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("registerTime=" + registerTime)
                .add("registerWay='" + registerWay + "'")
                .toString();
    }
}
