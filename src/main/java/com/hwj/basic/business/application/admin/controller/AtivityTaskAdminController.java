package com.hwj.basic.business.application.admin.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.converter.activitytaskconverter.ActivityTaskConfigVOConverter;
import com.hwj.basic.business.application.converter.activitytaskconverter.ActivityTaskVOConverter;
import com.hwj.basic.business.application.params.PageParams;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.business.application.vo.activitytaskvo.ActivityTaskConfigVO;
import com.hwj.basic.business.application.vo.activitytaskvo.ActivityTaskVO;
import com.hwj.basic.business.application.vo.PageVO;
import com.hwj.basic.common.activity.dto.ActivityDTO;
import com.hwj.basic.common.activity.service.ActivityReadService;
import com.hwj.basic.common.activitytask.dto.ActivityTaskDTO;
import com.hwj.basic.common.activitytask.service.ActivityTaskReadService;
import com.hwj.basic.common.activitytask.service.ActivityTaskWriteService;
import com.hwj.basic.mybatis.DataPage;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/activityTask")
public class AtivityTaskAdminController {

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityTaskReadService activityTaskReadService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityReadService activityReadService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityTaskWriteService activityTaskWriteService;


    @PostMapping("/page")
    public ApiResult<PageVO<ActivityTaskVO>> page(
            @ModelAttribute PageParams<ActivityTaskDTO> pageParams,
            @ModelAttribute ActivityTaskDTO queryParams){

        //查询分页数据
        DataPage<ActivityTaskDTO> dataPage = pageParams.toDataPage();
        RpcResult<DataPage<ActivityTaskDTO>> rpcResult = activityTaskReadService.queryPage(dataPage, queryParams);

        if (!rpcResult.isSuccess()){
            return ApiResult.failed(rpcResult.getCode(),rpcResult.getMsg());
        }

        //根据activityId来查activityName
        List<Long> activityIds = rpcResult.getData().getDataList().stream()
                .map(ActivityTaskDTO::getActivityId)
                .distinct()
                .collect(Collectors.toList());

        Map<Long, String> activityNameMap = new HashMap<>();

        if (!activityIds.isEmpty()){
            RpcResult<List<ActivityDTO>> listResult =
                    activityReadService.queryActivityList(activityIds);
            if (listResult.isSuccess()) {
                activityNameMap.putAll(
                        listResult.getData().stream()
                                .collect(Collectors.toMap(ActivityDTO::getId, ActivityDTO::getName))
                );
            }
        }

        // DTO转VO
        List<ActivityTaskVO> voList = rpcResult.getData().getDataList().stream()
                .map(dto -> ActivityTaskVOConverter.toVO(dto, activityNameMap))
                .collect(Collectors.toList());

        PageVO<ActivityTaskVO> pageVO = new PageVO<>();
        pageVO.setTotal(rpcResult.getData().getTotalCount());
        pageVO.setData(voList);

        return ApiResult.success(pageVO);
    }


    @PostMapping("/save")
    public ApiResult<Long> saveActivityTaskConfig(@RequestBody ActivityTaskConfigVO vo){
        // 验证关联活动是否存在
        Long activityId = vo.getActivityId();
        if (activityId == null){
            return ApiResult.failed("PARAM_MISS", "关联活动不能为空");
        }

        RpcResult<ActivityDTO> activityResult = activityReadService.queryById(vo.getActivityId());
        if (!activityResult.isSuccess() || activityResult.getData() == null) {
            return ApiResult.failed(activityResult.getCode(), activityResult.getMsg());
        }

        ActivityTaskDTO dto = ActivityTaskConfigVOConverter.toDTO(vo);

        RpcResult<ActivityTaskDTO> rpcResult = activityTaskWriteService.create(dto);
        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult.getCode(), rpcResult.getMsg());
        }

        return ApiResult.success(rpcResult.getData().getId());

    }

    @PostMapping("/update")
    public ApiResult<Long> updateActivityTaskConfig(@RequestBody ActivityTaskConfigVO vo){

        RpcResult<ActivityDTO> activityResult = activityReadService.queryById(vo.getActivityId());
        if (!activityResult.isSuccess() || activityResult.getData() == null) {
            return ApiResult.failed(activityResult.getCode(), activityResult.getMsg());
        }

        ActivityTaskDTO dto = ActivityTaskConfigVOConverter.toDTO(vo);

        RpcResult<ActivityTaskDTO> updateResult = activityTaskWriteService.update(dto);
        if (!updateResult.isSuccess()) {
            return ApiResult.failed(updateResult.getCode(), updateResult.getMsg());
        }

        return ApiResult.success(updateResult.getData().getId());

    }



    // 查询活动任务配置详情
    @GetMapping("/detail/{id}")
    public ApiResult<ActivityTaskConfigVO> getActivityTaskConfig(@PathVariable Long id) {
        RpcResult<ActivityTaskDTO> result = activityTaskReadService.queryById(id);
        if (!result.isSuccess()) {
            return ApiResult.failed(result.getCode(), result.getMsg());
        }
        ActivityTaskConfigVO vo = ActivityTaskConfigVOConverter.toVO(result.getData());
        return ApiResult.success(vo);
    }

}
