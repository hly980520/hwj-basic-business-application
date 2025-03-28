package com.hwj.basic.business.application.converter.activitytaskconverter;

import com.alibaba.fastjson2.JSONObject;
import com.hwj.basic.business.application.vo.activitytaskvo.ActivityTaskConfigVO;
import com.hwj.basic.business.application.vo.activitytaskvo.RewardItemVO;
import com.hwj.basic.business.application.vo.activitytaskvo.RuleItemVO;
import com.hwj.basic.common.activitytask.dto.ActivityTaskDTO;

import java.util.List;

public class ActivityTaskConfigVOConverter {

    public static ActivityTaskDTO toDTO(ActivityTaskConfigVO vo){
        ActivityTaskDTO dto = new ActivityTaskDTO();
        dto.setId(vo.getId());
        dto.setName(vo.getName());
        dto.setActivityId(vo.getActivityId());
        dto.setStatus(vo.getStatus());


        // 序列化奖励配置到 reward_config
        JSONObject rewardConfig = new JSONObject();
        rewardConfig.put("rewards", vo.getRewards());
        dto.setRewardConfig(rewardConfig.toJSONString());

        // 序列化规则配置到 rule_config
        JSONObject ruleConfig = new JSONObject();
        ruleConfig.put("rules", vo.getRules());
        dto.setRuleConfig(ruleConfig.toJSONString());

        return dto;
    }

    public static ActivityTaskConfigVO toVO(ActivityTaskDTO dto) {
        ActivityTaskConfigVO vo = new ActivityTaskConfigVO();
        vo.setId(dto.getId());
        vo.setName(dto.getName());
        vo.setActivityId(dto.getActivityId());
        vo.setStatus(dto.getStatus());


        // 反序列化奖励配置
        JSONObject rewardConfig = JSONObject.parseObject(dto.getRewardConfig());
        List<RewardItemVO> rewards = rewardConfig.getJSONArray("rewards")
                .toJavaList(RewardItemVO.class);
        vo.setRewards(rewards);

        // 反序列化规则配置
        JSONObject ruleConfig = JSONObject.parseObject(dto.getRuleConfig());
        List<RuleItemVO> rules = ruleConfig.getJSONArray("rules")
                .toJavaList(RuleItemVO.class);
        vo.setRules(rules);

        return vo;
    }
}
