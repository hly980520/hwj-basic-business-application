package com.hwj.basic.business.application.converter.memberoperconverter;

import com.hwj.basic.business.application.vo.memberopervo.MemberOperLogVO;
import com.hwj.basic.common.memberoperlog.dto.MemberOperDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberOperLogVOConverter {

    MemberOperLogVO from(MemberOperDTO memberOperDTO);

    MemberOperDTO toDTO(MemberOperLogVO memberOperLogVO);

}
