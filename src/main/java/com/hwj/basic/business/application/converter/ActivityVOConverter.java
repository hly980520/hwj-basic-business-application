package com.hwj.basic.business.application.converter;

import com.hwj.basic.business.application.vo.ActivityVO;
import com.hwj.basic.common.activity.dto.ActivityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityVOConverter {

    ActivityVO from(ActivityDTO activityDTO);

    ActivityDTO toDTO(ActivityVO activityVO);
}
