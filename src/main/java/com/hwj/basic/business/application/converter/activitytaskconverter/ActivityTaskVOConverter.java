package com.hwj.basic.business.application.converter.activitytaskconverter;

import com.hwj.basic.business.application.vo.activitytaskvo.ActivityTaskVO;
import com.hwj.basic.common.activitytask.dto.ActivityTaskDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ActivityTaskVOConverter {

    public static ActivityTaskVO toVO(ActivityTaskDTO dto, Map<Long, String> activityNameMap) {

        ActivityTaskVO vo = new ActivityTaskVO();

        // 基础字段映射
        vo.setId(dto.getId());
        vo.setName(dto.getName());
        // 根据activityId从Map中获取活动名称
        vo.setActivityName(activityNameMap.getOrDefault(dto.getActivityId(), "未知活动"));
        // 状态码转文本
        vo.setStatusText(convertStatusToText(dto.getStatus()));
        // 时间格式化
        vo.setCreatedDate(formatDateTime(dto.getCreatedDate()));
        vo.setCreatedBy(dto.getCreatedBy());
        vo.setUpdatedDate(formatDateTime(dto.getUpdatedDate()));
        vo.setUpdatedBy(dto.getUpdatedBy());
        return vo;
    }

    // VO转DTO
    public static ActivityTaskDTO toDTO(ActivityTaskVO vo) {
        ActivityTaskDTO dto = new ActivityTaskDTO();
        dto.setId(vo.getId());
        dto.setName(vo.getName());
        dto.setStatus(convertTextToStatus(vo.getStatusText()));
        dto.setCreatedDate(parseDateTime(vo.getCreatedDate()));
        dto.setCreatedBy(vo.getCreatedBy());
        dto.setUpdatedDate(parseDateTime(vo.getUpdatedDate()));
        dto.setUpdatedBy(vo.getUpdatedBy());
        return dto;
    }

    // 状态码转文本
    private static String convertStatusToText(Integer status) {
        switch (status) {
            case 0: return "草稿";
            case 1: return "上线";
            case 2: return "下线";
            default: return "未知";
        }
    }

    // 状态文本转码
    private static Integer convertTextToStatus(String statusText) {
        switch (statusText) {
            case "草稿": return 0;
            case "上线": return 1;
            case "下线": return 2;
            default: return -1;
        }
    }

    // 时间格式化
    private static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {return null;}
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // 时间解析
    private static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null){ return null;}
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
