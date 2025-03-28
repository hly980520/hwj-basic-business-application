package com.hwj.basic.business.application.admin.controller;

import com.hwj.basic.business.application.constant.DubboConst;
import com.hwj.basic.business.application.converter.activityconverter.ActivityAddUpdateVOConverter;
import com.hwj.basic.business.application.converter.activityconverter.ActivityVOConverter;
import com.hwj.basic.business.application.params.PageParams;
import com.hwj.basic.business.application.result.ApiResult;
import com.hwj.basic.business.application.vo.activityvo.ActivityAddUpdateVO;
import com.hwj.basic.business.application.vo.activityvo.ActivityVO;
import com.hwj.basic.business.application.vo.PageVO;
import com.hwj.basic.common.activity.dto.ActivityDTO;
import com.hwj.basic.common.activity.service.ActivityReadService;
import com.hwj.basic.common.activity.service.ActivityWriteService;
import com.hwj.basic.common.activityrule.dto.ActivityRuleTextDTO;
import com.hwj.basic.common.activityrule.service.ActivityRuleTextWriteService;
import com.hwj.basic.mybatis.DataPage;
import com.hwj.basic.result.RpcResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/activity")
public class ActivityAdminController {

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityReadService activityReadService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityWriteService activityWriteService;

    @DubboReference(consumer = DubboConst.CONSUMER_HWJ_BASIC_SERVER)
    private ActivityRuleTextWriteService ruleTextWriteService;

    @Resource
    private ActivityVOConverter activityVOConverter;

    @Resource
    private ActivityAddUpdateVOConverter activityAddUpdateVOConverter;

    // 分页查询
    @GetMapping("/page")
    public ApiResult<PageVO<ActivityVO>> page(
            @ModelAttribute PageParams<ActivityDTO> pageParams,
            @ModelAttribute ActivityDTO queryParams) {

        RpcResult<DataPage<ActivityDTO>> rpcResult = activityReadService.queryPage(pageParams.toDataPage(), queryParams);
        if (!rpcResult.isSuccess()) {
            return ApiResult.failed(rpcResult);
        }

        // 将 DataPage<ActivityDTO> 转换为 DataPage<ActivityVO>
        DataPage<ActivityVO> activityVODataPage = new DataPage<>();
        activityVODataPage.setTotalCount(rpcResult.getData().getTotalCount());
        activityVODataPage.setPageNo(rpcResult.getData().getPageNo());
        activityVODataPage.setPageSize(rpcResult.getData().getPageSize());
        activityVODataPage.setDataList(rpcResult.getData().getDataList().stream()
                .map(activityDTO -> activityVOConverter.toActivityVO(activityDTO))
                .collect(Collectors.toList()));

        return ApiResult.success(PageVO.toPageVO(activityVODataPage));
    }

    @PostMapping("/save")
    public ApiResult<Long> saveActivity(@RequestBody ActivityAddUpdateVO vo){
        // vo转dto
        ActivityDTO activityDTO = activityAddUpdateVOConverter.toActivityDTO(vo);
        ActivityRuleTextDTO ruleTextDTO = activityAddUpdateVOConverter.toActivityRuleTextDTO(vo);

        // 保存活动基本信息
        RpcResult<ActivityDTO> activityResult = activityWriteService.create(activityDTO);
        if (!activityResult.isSuccess()) {
            return ApiResult.failed(activityResult.getCode(), activityResult.getMsg());
        }
        Long activityId = activityResult.getData().getId();

        //保存活动规则文案
        ruleTextDTO.setActivityId(activityId);
        RpcResult<ActivityRuleTextDTO> ruleResult = ruleTextWriteService.create(ruleTextDTO);
        if (!ruleResult.isSuccess()) {
            return ApiResult.failed(ruleResult.getCode(), ruleResult.getMsg());
        }

        return ApiResult.success(activityId);

    }

    @PostMapping("/update")
    public ApiResult<Long> updateActivity(@RequestBody ActivityAddUpdateVO vo){
        // vo转dto
        ActivityDTO activityDTO = activityAddUpdateVOConverter.toActivityDTO(vo);
        ActivityRuleTextDTO ruleTextDTO = activityAddUpdateVOConverter.toActivityRuleTextDTO(vo);

        //修改活动基本信息
        RpcResult<ActivityDTO> activityResult = activityWriteService.update(activityDTO);
        if (!activityResult.isSuccess()) {
            return ApiResult.failed(activityResult.getCode(), activityResult.getMsg());
        }
        Long activityId = activityDTO.getId();

        //修改文案规则
        ruleTextDTO.setActivityId(activityId);
        RpcResult<ActivityRuleTextDTO> ruleResult = ruleTextWriteService.update(ruleTextDTO);
        if (!ruleResult.isSuccess()) {
            return ApiResult.failed(ruleResult.getCode(), ruleResult.getMsg());
        }

        return ApiResult.success(activityId);

    }


}
