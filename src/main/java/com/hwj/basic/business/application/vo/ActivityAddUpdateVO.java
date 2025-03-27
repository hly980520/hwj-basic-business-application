package com.hwj.basic.business.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

//活动新增、编辑
public class ActivityAddUpdateVO implements Serializable {
    private static final long serialVersionUID = 4720973275308778385L;

    private Long id;
    private String activityName;
    private Integer activityType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String ruleText;

    // 存量运营活动专属配置
    private Boolean limitExistingUser;
    private String targetUserType;

    // 获客活动专属配置
    private Boolean limitRegisterWay;
    private String registerWay;

    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public Boolean getLimitExistingUser() {
        return limitExistingUser;
    }

    public void setLimitExistingUser(Boolean limitExistingUser) {
        this.limitExistingUser = limitExistingUser;
    }

    public String getTargetUserType() {
        return targetUserType;
    }

    public void setTargetUserType(String targetUserType) {
        this.targetUserType = targetUserType;
    }

    public Boolean getLimitRegisterWay() {
        return limitRegisterWay;
    }

    public void setLimitRegisterWay(Boolean limitRegisterWay) {
        this.limitRegisterWay = limitRegisterWay;
    }

    public String getRegisterWay() {
        return registerWay;
    }

    public void setRegisterWay(String registerWay) {
        this.registerWay = registerWay;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ActivityAddUpdateVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("activityName='" + activityName + "'")
                .add("activityType=" + activityType)
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("ruleText=" + ruleText + "'")
                .add("limitExistingUser=" + limitExistingUser)
                .add("targetUserType='" + targetUserType + "'")
                .add("limitRegisterWay=" + limitRegisterWay)
                .add("registerWay='" + registerWay + "'")
                .add("createdBy='" + createdBy + "'")
                .add("createdDate='" + createdDate)
                .add("updatedBy='" + updatedBy + "'")
                .add("updatedDate='" + updatedDate)
                .toString();
    }

}
