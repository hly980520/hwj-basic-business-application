package com.hwj.basic.business.application.converter;

import com.hwj.basic.business.application.vo.ActivityTaskVO;
import com.hwj.basic.common.activitytask.dto.ActivityTaskDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityTaskVOConverter {

    ActivityTaskVO from(ActivityTaskDTO activityTaskDTO);

    ActivityTaskDTO toDTO(ActivityTaskVO activityTaskVO);

}
