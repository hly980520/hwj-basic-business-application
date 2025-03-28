package com.hwj.basic.business.application.converter.memberconverter;

import com.alibaba.fastjson2.JSONObject;
import com.hwj.basic.business.application.vo.membervo.MemberVO;
import com.hwj.basic.common.member.domain.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberVOConverter {

    @Mapping(target = "registerTime",source = "createdDate")
    @Mapping(target = "thirdNum",source = "registerCredentials",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "memberStatus", expression = "java(extractMemberStatus(member.getFeatures()))")
    MemberVO toMemberVO(Member member);

    // 自定义方法：从 features 中提取用户状态
    default String extractMemberStatus(JSONObject features) {
        if (features == null){ return "未知";}
        // 假设 features 中存储状态的字段名为 "status"
        return features.getString("status");
    }

    @Mapping(target = "createdDate",source = "registerTime")
    @Mapping(target = "registerCredentials",source = "thirdNum")
    @Mapping(target = "features", expression = "java(buildFeatures(memberVO.getMemberStatus()))")
    Member toMemberDTO(MemberVO memberVO);

    default JSONObject buildFeatures(String memberStatus) {
        JSONObject features = new JSONObject();
        features.put("status", memberStatus);
        return features;
    }

}
