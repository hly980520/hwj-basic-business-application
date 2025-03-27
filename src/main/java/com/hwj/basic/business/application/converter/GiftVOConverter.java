package com.hwj.basic.business.application.converter;

import com.hwj.basic.business.application.vo.GiftVO;
import com.hwj.basic.common.gift.dto.GiftDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GiftVOConverter {

    GiftVO from(GiftDTO giftDTO);

    GiftDTO toDTO(GiftVO giftVO);

}
