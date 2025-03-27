package com.hwj.basic.business.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户管理
public class MemberVO implements Serializable {
    private static final long serialVersionUID = 142076892042893752L;

    private Long id;

    private String nickName;

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

    //操作
    private String operation;

    @Override
    public String toString() {
        return new StringJoiner(", ", MemberVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nickName='" + nickName + "'")
                .add("loginAccount='" + loginAccount + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("registerWay='" + registerWay + "'")
                .add("thirdNum='" + thirdNum + "'")
                .add("memberStatus=" + memberStatus)
                .add("updatedDate=" + updatedDate)
                .add("updatedBy=" + updatedBy)
                .add("operation=" + operation + "'")
                .toString();
    }

}
