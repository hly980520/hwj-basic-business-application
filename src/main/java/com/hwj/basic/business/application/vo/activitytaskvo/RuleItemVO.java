package com.hwj.basic.business.application.vo.activitytaskvo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class RuleItemVO implements Serializable {
    private static final long serialVersionUID = 1448443375267801374L;

    // 规则类型（如 "注册规则"）
    private String ruleType;
    // 时间类型（如 "活动时间"）
    private String timeType;
    // 开始时间（timeType有效）
    private LocalDateTime startTime;
    // 结束时间（timeType为有效）
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return new StringJoiner(", ", RuleItemVO.class.getSimpleName() + "[", "]")
                .add("rewardId=" + ruleType)
                .add("sendType='" + timeType + "'")
                .add("startTime=" + startTime)
                .add("endTime=" + endTime)
                .toString();
    }
}
