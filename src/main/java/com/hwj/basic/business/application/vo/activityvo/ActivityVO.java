package com.hwj.basic.business.application.vo.activityvo;

import java.io.Serializable;
import java.util.StringJoiner;

//活动列表
public class ActivityVO implements Serializable {

    private static final long serialVersionUID = 1841737632950157588L;

    private Long id;
    // 活动名称
    private String name;
    // 活动类型中文（如"获客"）
    private String activityTypeText;
    // 状态中文（如"上线"）
    private String statusText;
    private String startTime;
    private String endTime;
    private String updatedDate;
    // 更新人
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityTypeText() {
        return activityTypeText;
    }

    public void setActivityTypeText(String activityTypeText) {
        this.activityTypeText = activityTypeText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ActivityVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("activityTypeText=" + activityTypeText)
                .add("statusText=" + statusText)
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .add("updatedDate=" + updatedDate)
                .add("updatedBy='" + updatedBy + "'")
                .toString();
    }

}
