package com.hwj.basic.business.application.converter.activityconverter;

import com.hwj.basic.business.application.vo.activityvo.ActivityVO;
import com.hwj.basic.common.activity.dto.ActivityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityVOConverter {

    @Mapping(target = "activityTypeText", expression = "java(mapActivityType(activityDTO.getActivityType()))")
    @Mapping(target = "statusText", expression = "java(mapStatus(activityDTO.getStatus()))")
    @Mapping(target = "startTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "endTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updatedDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ActivityVO toActivityVO(ActivityDTO activityDTO);

    // 转换逻辑
    default String mapActivityType(Integer activityType) {
        switch (activityType) {
            case 0: return "获客";
            case 1: return "存量运营";
            default: return "未知";
        }
    }

    // 转换逻辑
    default String mapStatus(Integer status) {
        switch (status) {
            case 0: return "草稿";
            case 1: return "上线";
            case 2: return "下线";
            default: return "未知";
        }
    }


    @Mapping(target = "activityType",expression = "java(mapActivityTypeText(activityVO.getActivityTypeText()))")
    @Mapping(target = "status", expression = "java(mapStatusText(activityVO.getStatusText()))")
    @Mapping(target = "startTime",source = "startTime")
    @Mapping(target = "endTime",source = "endTime")
    @Mapping(target = "updatedDate",source = "updatedDate")
    ActivityDTO toActivityDTO(ActivityVO activityVO);

    // 将中文活动类型转换为编码
    default Integer mapActivityTypeText(String activityTypeText) {
        switch (activityTypeText) {
            case "获客": return 0;
            case "存量运营": return 1;
            default: return -1; // 或抛出异常
        }
    }

    default Integer mapStatusText(String statusText) {
        switch (statusText) {
            case "草稿": return 0;
            case "上线": return 1;
            case "下线": return 2;
            default: return -1; // 或抛出异常
        }
    }


}
