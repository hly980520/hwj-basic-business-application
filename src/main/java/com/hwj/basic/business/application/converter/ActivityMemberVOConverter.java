package com.hwj.basic.business.application.converter;

import com.hwj.basic.business.application.vo.ActivityMemberVO;
import com.hwj.basic.common.activitymember.dto.ActivityMemberDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMemberVOConverter {

    ActivityMemberVO from(ActivityMemberDTO activityMemberDTO);

    ActivityMemberDTO toDTO(ActivityMemberVO activityMemberVO);

}
