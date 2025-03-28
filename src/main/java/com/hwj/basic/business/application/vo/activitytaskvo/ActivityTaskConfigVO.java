package com.hwj.basic.business.application.vo.activitytaskvo;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

public class ActivityTaskConfigVO implements Serializable {
    private static final long serialVersionUID = 8993008815428163368L;

    //基础配置
    private Long id;
    private String name;
    // 关联活动：活动id+活动名称
    private Long activityId;
    private String msgEventCode;

    // 奖品配置列表
    private List<RewardItemVO> rewards;
    // 规则配置列表
    private List<RuleItemVO> rules;
    private Integer status;

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


    public String getMsgEventCode() {
        return msgEventCode;
    }

    public void setMsgEventCode(String msgEventCode) {
        this.msgEventCode = msgEventCode;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public List<RewardItemVO> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardItemVO> rewards) {
        this.rewards = rewards;
    }

    public List<RuleItemVO> getRules() {
        return rules;
    }

    public void setRules(List<RuleItemVO> rules) {
        this.rules = rules;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ActivityTaskConfigVO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("activityId=" + activityId)
                .add("msgEventCode=" + msgEventCode + "'")
                .add("rewards=" + rewards)
                .add("rules=" + rules)
                .add("status=" + status)
                .toString();
    }
}
