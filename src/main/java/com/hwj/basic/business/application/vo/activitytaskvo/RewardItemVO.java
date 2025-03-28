package com.hwj.basic.business.application.vo.activitytaskvo;

import java.io.Serializable;
import java.util.StringJoiner;

public class RewardItemVO implements Serializable {
    private static final long serialVersionUID = 4749923045391946955L;

    // 奖品ID（如 "101 - 京东50元购物卡"）
    private String rewardId;
    // 发放方式（1:自动发放, 2:手动领取）
    private Integer sendType;

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RewardItemVO.class.getSimpleName() + "[", "]")
                .add("rewardId=" + rewardId)
                .add("sendType='" + sendType + "'")
                .toString();
    }
}
