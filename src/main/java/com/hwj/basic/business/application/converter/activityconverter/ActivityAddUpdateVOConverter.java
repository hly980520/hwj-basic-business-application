package com.hwj.basic.business.application.converter.activityconverter;

import com.alibaba.fastjson2.JSONObject;
import com.hwj.basic.business.application.vo.activityvo.ActivityAddUpdateVO;
import com.hwj.basic.business.application.vo.activityvo.ActivityVO;
import com.hwj.basic.common.activity.dto.ActivityDTO;
import com.hwj.basic.common.activityrule.dto.ActivityRuleTextDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActivityAddUpdateVOConverter {

    @Mapping(target = "activityTypeText",source = "activityType")
    @Mapping(target = "statusText", source = "status")
    @Mapping(target = "startTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "endTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updatedDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ActivityVO toActivityVO(ActivityDTO activityDTO);

    @Mapping(target = "name", source = "activityName")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "features", ignore = true)
    ActivityDTO toActivityDTO(ActivityAddUpdateVO activityAddUpdateVO);

    @Mapping(target = "activityId", source = "id")
    @Mapping(target = "ruleText", source = "ruleText")
    ActivityRuleTextDTO toActivityRuleTextDTO(ActivityAddUpdateVO vo);

    // 补充features字段的映射逻辑
    @AfterMapping
    default void afterMapping(ActivityAddUpdateVO vo, @MappingTarget ActivityDTO dto) {
        JSONObject features = new JSONObject();
        if (vo.getActivityType() == 2) { // 存量运营活动
            features.put("limitExistingUser", vo.getLimitExistingUser());
            features.put("targetUserType", vo.getTargetUserType());
        } else if (vo.getActivityType() == 1) { // 获客活动
            features.put("limitRegisterWay", vo.getLimitRegisterWay());
            features.put("registerWay", vo.getRegisterWay());
        }
        dto.setFeatures(features);
    }

}
