package com.hwj.basic.business.application.converter;

import com.hwj.basic.business.application.vo.MemberVO;
import com.hwj.basic.common.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberVOConverter {

    @Mapping(target = "registerTime",source = "createdDate")
    @Mapping(target = "thirdNum",source = "registerCredentials")
    MemberVO from(Member member);

    Member toDTO(MemberVO memberVO);

}
