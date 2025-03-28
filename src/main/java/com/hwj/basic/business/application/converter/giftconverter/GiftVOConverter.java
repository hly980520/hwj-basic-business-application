package com.hwj.basic.business.application.converter.giftconverter;

import com.hwj.basic.business.application.vo.giftvo.GiftVO;
import com.hwj.basic.common.gift.dto.GiftDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GiftVOConverter {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static GiftVO dtoToVo(GiftDTO giftDTO, Integer issueCount) {
        GiftVO vo = new GiftVO();
        vo.setId(giftDTO.getId());
        vo.setGiftName(giftDTO.getName());
        vo.setGiftType(giftDTO.getGiftType());
        vo.setIssueCount(issueCount); // 注入发放数量
        vo.setCreatedDate(giftDTO.getCreatedDate().format(DATE_FORMATTER));
        vo.setCreatedBy(giftDTO.getCreatedBy());
        vo.setUpdatedDate(giftDTO.getUpdatedDate().format(DATE_FORMATTER));
        vo.setUpdatedBy(giftDTO.getUpdatedBy());
        return vo;
    }

    public static GiftDTO voToDto(GiftVO giftVO) {
        GiftDTO dto = new GiftDTO();
        dto.setId(giftVO.getId());
        dto.setName(giftVO.getGiftName());
        dto.setGiftType(giftVO.getGiftType());
        dto.setCreatedDate(LocalDateTime.parse(giftVO.getCreatedDate(), DATE_FORMATTER));
        dto.setCreatedBy(giftVO.getCreatedBy());
        dto.setUpdatedDate(LocalDateTime.parse(giftVO.getUpdatedDate(), DATE_FORMATTER));
        dto.setUpdatedBy(giftVO.getUpdatedBy());
        return dto;
    }

}
