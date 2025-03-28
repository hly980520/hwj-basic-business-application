package com.hwj.basic.business.application.vo.membermissionvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//用户任务
public class MemberMissionVO implements Serializable {

    private static final long serialVersionUID = 319274701313196722L;
    private Long id;

    private Long memberId;

    //用户号
    private String loginAccount;

    //任务名称
    private String taskName;

    //活动名称
    private String activityName;

    private Integer qualified;

    private Integer achievable;

    private LocalDateTime createdDate;

    //发放时间
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getQualified() {
        return qualified;
    }

    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }

    public Integer getAchievable() {
        return achievable;
    }

    public void setAchievable(Integer achievable) {
        this.achievable = achievable;
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
        return new StringJoiner(", ", MemberMissionVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("memberId='" + memberId)
                .add("loginAccount=" + loginAccount + "'")
                .add("taskName=" + taskName + "'")
                .add("activityName=" + activityName + "'")
                .add("qualified=" + qualified)
                .add("achievable=" + achievable)
                .add("createdDate='" + createdDate + "'")
                .add("sendTime='" + sendTime + "'")
                .toString();
    }

}
