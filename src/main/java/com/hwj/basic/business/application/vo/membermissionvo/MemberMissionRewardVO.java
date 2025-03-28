package com.hwj.basic.business.application.vo.membermissionvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户奖励
public class MemberMissionRewardVO implements Serializable {

    private static final long serialVersionUID = 3424594966927575790L;

    private Long id;

    private Long memberId;

    //用户号
    private String loginAccount;

    //任务名称
    private String taskName;

    //活动名称
    private Integer activityName;

    private Integer sendType;

    private Integer sendStatus;

    private Long sourceId;

    private LocalDateTime createdDate;

    private LocalDateTime sendTime;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getActivityName() {
        return activityName;
    }

    public void setActivityName(Integer activityName) {
        this.activityName = activityName;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", MemberMissionRewardVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId='" + memberId)
                .add("loginAccount=" + loginAccount + "'")
                .add("taskName=" + taskName + "'")
                .add("activityName=" + activityName + "'")
                .add("sendType=" + sendType)
                .add("sendStatus=" + sendStatus)
                .add("sourceId=" + sourceId)
                .add("createdDate=" + createdDate)
                .add("sendTime='" + sendTime + "'")
                .toString();
    }

}
