package com.hwj.basic.business.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//活动用户
public class ActivityMemberVO implements Serializable {

    private static final long serialVersionUID = -5446424215470037696L;

    private Long id;

    private Long memberId;

    //用户号
    private String loginAccount;

    //活动名称
    private String activityName;

    private Integer status;

    // 活动参与时间
    private LocalDateTime participateDate;

    private LocalDateTime updatedDate;

    private String updatedBy;

    //操作
    private String operation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getParticipateDate() {
        return participateDate;
    }

    public void setParticipateDate(LocalDateTime participateDate) {
        this.participateDate = participateDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ActivityMemberVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId='" + memberId)
                .add("loginAccount=" + loginAccount + "'")
                .add("activityName=" + status + "'")
                .add("status=" + status)
                .add("participateDate=" + participateDate)
                .add("updatedDate=" + updatedDate)
                .add("updatedBy='" + updatedBy + "'")
                .add("operation=" + operation + "'")
                .toString();
    }
}
